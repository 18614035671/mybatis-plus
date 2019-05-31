package com.disp.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * MybatisPlus全局配置 3.1.1的yml不生效
 */
@Configuration
public class MybatisPlusConfig {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    /**
     * 乐观锁
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactory() throws Exception{
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean= new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // MyBatis Mapper 所对应的 XML 文件位置，如果您在 Mapper 中有自定义方法(XML 中有自定义实现)，需要进行该配置，告诉 Mapper 所对应的 XML 文件位置
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/**/*Dao.xml"));
        // MyBaits 别名包扫描路径，通过该属性可以给包中的类注册别名，注册后在 Mapper 对应的 XML 文件中可以直接使用类名，而不用使用全限定的类名(即 XML 中调用的时候不用包含包名)
        sqlSessionFactoryBean.setTypeAliasesPackage("com.disp.*.entity");
        sqlSessionFactoryBean.setTypeEnumsPackage("com.disp.common.enums");

        // GlobalConfig 配置
        GlobalConfig globalConfig = new GlobalConfig();
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setIdType(IdType.AUTO);
        dbConfig.setTableUnderline(true);
        dbConfig.setCapitalMode(false);
        dbConfig.setFieldStrategy(FieldStrategy.NOT_NULL);
        globalConfig.setDbConfig(dbConfig);
        globalConfig.setEnableSqlRunner(true);
        sqlSessionFactoryBean.setGlobalConfig(globalConfig);

        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        // 打印sql
        mybatisConfiguration.setLogImpl(StdOutImpl.class);
        mybatisConfiguration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
        mybatisConfiguration.setCacheEnabled(false);
        mybatisConfiguration.setCallSettersOnNulls(true);
        sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
        List<Interceptor> interceptors = new ArrayList<>();
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置数据库
        paginationInterceptor.setDialectType(DbType.MYSQL.getDb());
        // 设置分页插件
        interceptors.add(paginationInterceptor);
        sqlSessionFactoryBean.setPlugins(interceptors.toArray(new Interceptor[0]));
        System.out.println("sqlSessionFactory注入成功》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》");
        return sqlSessionFactoryBean;
    }

    @Bean
    @Profile({"dev", "test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // dev环境,格式化输出的sql语句
        performanceInterceptor.setFormat(true);
        performanceInterceptor.setMaxTime(5000);
        return performanceInterceptor;
    }
}