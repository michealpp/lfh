package basic.com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("basic.com")
public class AppConfig{
    //通过@Component标注bean，这样就无需使用下面的方法注册了。
    // @Bean
    // public MessageRepository messageRepository(){
    //     return new MessageRepository();
    // }
    //
    // @Bean
    // MessageService messageService(){
    //     //手动管理构造函数注入，bean多了，会累死
    //     return new MessageService(messageRepository());
    // }
}