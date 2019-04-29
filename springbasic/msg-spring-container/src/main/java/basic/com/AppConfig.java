package basic.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("basic.com")
public class AppConfig{
    @Bean
    public MessageRepository messageRepository(){
        return new MessageRepository();
    }

    @Bean
    MessageService messageService(){
        //手动管理构造函数注入，bean多了，会累死
        return new MessageService(messageRepository());
    }
}