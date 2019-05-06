package basic.com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**本例target:
 * 理解3类依赖注入，学会如何使用，并了解它们的应用场合。
 * 
 * 依赖注入：
 * 需要由Spring管理的类(bean)，用声明类annotation标注对应的class，
 * 这样Spring就会从@ComponentScan指定的包中找出并管理起来。
 *
 * 声明bean的annotation：
 * @Component 声明常规bean
 * @Service 声明服务类，是特殊的@Component
 * @Controller 声明web controller类
 * @Repository 声明存储库类
 * 
 * 三类依赖注入：
 * Constructor-based injection
 * Setter-based/method-based injection
 * Field-based injection
 * 最佳实践：对于可选依赖，使用基于方法的依赖注入；对于必须的依赖，使用基于构造函数的依赖注入；
 * 而基于field的依赖注入则要近可能的避免使用，Spring通过反射实现field依赖注入并且被认为使用field依赖注入是有害的。
 * Field-based injection hides the information of the dependencies, such as how they are initialized and managed, and what these dependencies depend on.
 * Field injection is very easy, as you only need to define a field and apply the @Autowired or @Resource annotation to it. Developers can get addicted to this and add too many dependencies and violate the Single Responsibility Principle (SRP).
 * 
 * 依赖注入的annotation:
 * @Required用于setter方法，不再使用
 * @Autowired可以用于构造函数、方法和字段(field)
 * 
 * 基于构造函数的依赖注入 - 见MessageServiceCtor
 * -------------------------------
 * @Autowired
 * public contructor(beanCls obj)
 * -------------------------------
 * 其中@Autowired可以省略，这时Spring仍知道这里需要依赖注入
 * 
 *
 * 基于method的依赖注入 - 见MessageServiceMthd
 * -------------------------------
 * @Autowired
 * public void setBean(beanCls obj)
 * -------------------------------
 * 这时@Autowired不能省略
 * 
 * 
 * 基于field的依赖注入 - 见MessageServiceField
 * -------------------------------
 * @Autowired
 * private beanCls beanObj
 * -------------------------------
 * 
 */
public class App 
{
    private final static Log log = LogFactory.getLog(App.class);
    public static void main( String[] args )
    {
        log.info("*** into main ***");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //根据类取MessageService bean
        MessageServiceCtor msgService1 = context.getBean(MessageServiceCtor.class);
        msgService1.save("Hello, constructor-based injection!");
        
        MessageServiceMthd msgService2 = context.getBean(MessageServiceMthd.class);
        msgService2.save("Hello, method-based injection!");

        MessageServiceField msgService3 = context.getBean(MessageServiceField.class);
        msgService3.save("Hello, field-based injection!");
    }
}
