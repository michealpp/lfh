package micheal.com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //创建spring container
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //从spring container中取bean
        MessageService messageService = context.getBean(MessageService.class);
        messageService.save("Hello, Spring");
    }
}
