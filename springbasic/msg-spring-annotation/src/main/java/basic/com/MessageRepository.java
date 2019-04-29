package basic.com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * 数据库操作，全局只需要一个即可，由spring帮我们管理再合适不过了。
 */
@Component //声明bean
public class MessageRepository{
    private final static Log log = LogFactory.getLog(MessageRepository.class);

    public MessageRepository(){
        log.info("***MessageRepository()***");
    }

    public void saveMessage(Message message){
        log.info(String.format("***saveMessage(%s)***", message.getText()));
    }
}