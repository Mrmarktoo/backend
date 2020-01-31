##第一次学习使用mybatis，记录一下过程笔记

###第一次使用mybatis构建后端项目demo，参考的内容是：
* [MyBatis3.5入门教程](http://www.mybatis.cn/679.html)
* [MyBatis 3.5 + Maven 环境搭建](http://www.mybatis.cn/archives/397.html)

数据库连接配置：
db.properties

driver=com.mysql.jdbc.Driver//纠正一下，这里应该是这个driver，示例中写的driver应该是不对的

url=jdbc:mysql://localhost:3306/your_db_name?useSSL=false

username=your_user_name

password=your_user_pass

日志输出配置：
log4j.properties 

mybatis xml配置：
mybatis-config.xml

第一次使用采用的是注解形式实现mapper，方法中参数类型要注意，通过方法调用时会提示类型匹配，如果通过session方法全路径调用是，参数为object，实际运行时才会匹配mapper中参数类型，这种调用时要注意参数类型。

###过程中遇到错误
driver未设置：
mybatis 执行查询时报错 【Error querying database. Cause: java.sql.SQLException: Error setting driver on UnpooledDataSource. Cause: java.lang.ClassNotFoundException: Cannot find class: 】

mysql-connector-java的版本要大于5.1.44才会运行正常，否则会出现以下问题
：Cause: java.sql.SQLException: Error setting driver on UnpooledDataSource. Cause: java.lang.ClassNotFoundException: Cannot find class: com.mysql.jdbc.Driver

