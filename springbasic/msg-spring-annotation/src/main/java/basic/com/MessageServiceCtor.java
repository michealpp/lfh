package basic.com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数据库访问服务，全局一个即可，由spring帮我们管理
 */
@Component //声明bean
public class MessageServiceCtor {
    private final static Log log = LogFactory.getLog(MessageServiceCtor.class);

    //此处需要依赖注入，本例MessageServiceCtor通过构造函数注入MessageRepository
    private MessageRepository repository;

    @Autowired
    public MessageServiceCtor(MessageRepository repository){
        log.info(String.format("***MessageService(构造函数注入repository)***：%s", repository.toString()));
        this.repository = repository;
    }

    public void save(String text){
        log.info(String.format("***MessageService.save(%s)***: bean=%s", text, this.repository.toString()));
        this.repository.saveMessage(new Message(text));
    }
}