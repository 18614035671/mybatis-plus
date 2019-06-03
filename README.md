# mybatis-plus
springboot2.1.5 整合 mybatisplus3.1.1

mybatisplus-spring-boot-starter 2017年断更了 只支持springboot1.5.7
mybatis-plus yml配置不生效 所以采用官网Configuration的@Bean注入

Get请求：
    查询：http://localhost:8089/disp/user/getUser
    分页查询：http://localhost:8089/disp/user/getUserPage?currentPage=1&pageSize=5
Post请求：
    增加：http://localhost:8089/disp/user/insertUser
    修改http://localhost:8089/disp/user/updateUser
    删除http://localhost:8089/disp/user/deleteUser
    多个删除http://localhost:8089/disp/user/delAllUser