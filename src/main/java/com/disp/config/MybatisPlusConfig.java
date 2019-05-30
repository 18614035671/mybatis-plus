package com.disp.config;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * MybatisPlus全局配置 3.1.1的yml不生效
 */
@Configuration
public class MybatisPlusConfig {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

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
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:/mapper/*Dao.xml"));
        // MyBaits 别名包扫描路径，通过该属性可以给包中的类注册别名，注册后在 Mapper 对应的 XML 文件中可以直接使用类名，而不用使用全限定的类名(即 XML 中调用的时候不用包含包名)
        sqlSessionFactoryBean.setTypeAliasesPackage("com.disp.entity");
        sqlSessionFactoryBean.setTypeEnumsPackage("com.disp.common.enums");

        // GlobalConfig 配置
        GlobalConfig globalConfig = new GlobalConfig();
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setIdType(IdType.AUTO);
        dbConfig.setTableUnderline(true);
        dbConfig.setCapitalMode(false);
        dbConfig.setFieldStrategy(FieldStrategy.NOT_NULL);
        globalConfig.setDbConfig(dbConfig);
        sqlSessionFactoryBean.setGlobalConfig(globalConfig);

        // MybatisConfiguration
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        mybatisConfiguration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        mybatisConfiguration.setMapUnderscoreToCamelCase(true);
        mybatisConfiguration.setCacheEnabled(false);
        mybatisConfiguration.setCallSettersOnNulls(true);
        sqlSessionFactoryBean.setConfiguration(mybatisConfiguration);
        return sqlSessionFactoryBean;
    }
}