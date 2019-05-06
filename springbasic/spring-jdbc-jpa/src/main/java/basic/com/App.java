package basic.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**一、使用JDBC Driver操作DB
 * 依赖spring-boot-starter-jdbc提供DataSource，依赖mysql-connector-java，使用mysql-connector-java提供的API操作mysql
 * 1. POM指定为spring-boot application
 * 2. 添加依赖
 * 3. 配置build
 * 4. 添加application.properties配置DB
 * 5. 修改App类
 * 6. 添加AppConfig类
 * 7. 添加Message类和DB表对应
 * 8. 添加JdbcDriverMessageRepository类，构造函数注入DataSource对象（Spring jdbc提供该对象），操作DB
 * 9. 添加JdbcDriverMessageService类，构造函数注入JdbcDriverMessageRepository，操作DB
 * 10.添加JdbcDriverController类，构造函数注入JdbcDriverMessageService，操作DB
 * 11.添加MessageData POJO类，使用@RequestBody标注，用于接收http request body里面的json字符
 * 12.添加handler方法，处理http请求
 * 13.用postman验证：
 *   headers添加Content-Type:application/json，表示request body为json
 *   body选Raw 和 JSON (application/json)，输入{"text":"message from postman"}
 * 14.查看DB表是否插入数据
 * 
 * 二、使用Spring JDBC操作DB（使用JdbcTemplate来操作）
 * 依赖spring-boot-starter-jdbc提供DataSource，依赖mysql-connector-java，
 * 但不使用mysql-connector-java提供的API操作mysql，而是使用spring jdbc提供的JdbcTemplate来操作。
 * 
 * 三、使用ORM
 * 1.POM添加依赖spring-orm, hibernate-core
 * 2.
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
