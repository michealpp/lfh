package micheal.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //@Configuration表示该AppConfig是用于bean定义的
@ComponentScan("micheal.com")//@ComponentScan与@Configuration配合使用，指定要进行组件扫描的包
public class AppConfig{

    //@Bean标注的方法负责创建bean，bean的名字和方法名相同
    @Bean
    public MessageRepository messageRepository(){
        return new MessageRepository();
    }

    @Bean
    MessageService messageService(){
        //bean传入构造函数
        return new MessageService(messageRepository());
    }

}