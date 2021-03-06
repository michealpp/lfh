package basic.com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 数据库访问服务
 */
public class MessageService {
    private final static Log log = LogFactory.getLog(MessageService.class);
    //此处需要依赖注入，本例通过构造函数注入
    private MessageRepository repository;

    public MessageService(MessageRepository repository){
        log.info(String.format("***MessageService(构造函数注入repository)***：%s", repository.toString()));
        this.repository = repository;
    }

    public void save(String text){
        log.info(String.format("***MessageService.save(%s)***: bean=%s", text, this.repository.toString()));
        this.repository.saveMessage(new Message(text));
    }
}