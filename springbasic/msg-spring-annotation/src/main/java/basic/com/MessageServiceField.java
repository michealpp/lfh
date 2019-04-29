package basic.com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数据库访问服务，全局一个即可，由spring帮我们管理
 */
@Component //声明bean
public class MessageServiceField {
    private final static Log log = LogFactory.getLog(MessageServiceMthd.class);

    //此处需要依赖注入，本例MessageServiceField通过field注入MessageRepository
    @Autowired
    private MessageRepository repository;

    public void save(String text){
        log.info(String.format("***MessageService.save(%s)***: bean=%s", text, this.repository.toString()));
        this.repository.saveMessage(new Message(text));
    }
}