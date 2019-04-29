package basic.com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**预备知识：
 * https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html
 * maven项目基本结构
 * vscode相关插件
 *   ESLint(dbaeumer.vscode-eslint)
 *   Vetur(octref.vetur)
 *   Language Support for Java(TM) by Red Hat(redhat.java)
 *   Java Extension Pack(vscjava.vscode-java-pack)
 *   Debugger for Java(vscjava.vscode-java-debug)
 *   Spring Boot Tools(pivotal.vscode-spring-boot)
 *   Maven for Java(vscjava.vscode-maven)
 * POM：Project Object Model
 * 
 * 本例target:
 * 使用配置类的method实例化bean，手动处理constructor/setter依赖，适用于只有少量bean的情况，
 * 当bean有很多时，就需要耗费很多的精力来手动处理constructor/setter依赖，请体会这点（见配置类）。
 * 这个问题将在后续通过使用annotation-based配置来解决。
 * Spring提供了两类annotation，一类用于声明bean，另一类用于依赖注入(wire up dependency)。
 * 另外，还需要理解的是为什么本例中只有两个bean(messageService, messageRepository)，分别起什么作用。
 * 
 * 本例依赖库：
 *  spring-context：
 *  log4j-api：
 *  log4j-core：
 * 
 * Steps:
 * 1.创建 maven-archetype-quickstart 项目
 * 2.POM中设置java版本1.8
 * 3.POM中添加项目依赖：spring-context，log4j-api，log4j-core
 * 4.添加Message, POJO类
 * 5.添加MessageRepository类，负责和DB交互
 * 6.添加MessageService类，服务类，通过构造函数注入的方式注入MessageRepository
 * 7.添加AppConfig类
 * 该类为configuration metadata，spring会用它来初始化容器。
 * @Configuration标注对应类为配置类，用于定义bean
 * @ComponentScan和@Configuration一起使用，指定要扫描的包，用于找出标注的components
 * @Bean标注的方法负责生成bean，且方法名就是改bean的名字
 * 8.main函数中使用AppConfig类生成上下文对象，用于获取bean
 *   这里获取同一个bean两次，查看获得的对象是否为同一个。有助于你理解bean。
 * 9.添加log4j配置xml
 *   https://logging.apache.org/log4j/2.x/manual/configuration.html
 * 10.POM中添加build plugin，这里为maven-assembly-plugin并指明main函数所在的类。
 * 11.编译打包：mvn install
 * 12.运行java -jar .\target\msgIoc-jar-with-dependencies.jar
 *
 */
public class App 
{
    private final static Log log = LogFactory.getLog(App.class);
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //根据类取MessageService bean
        MessageService msgService1 = context.getBean(MessageService.class);
        msgService1.save("Hello, Spring!");
        
        //再次取MessageService bean
        MessageService msgService2 = context.getBean(MessageService.class);
        msgService2.save("Hello, Spring! Again!");

        //bean在容器中是唯一的，由容器管理
        log.info(String.format("***两个MessageService是同一个***: %s, %s", msgService1.toString(), msgService2.toString()));
    }
}
