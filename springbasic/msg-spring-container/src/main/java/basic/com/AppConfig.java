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
        return new MessageService(messageRepository());
    }
}