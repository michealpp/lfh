package basic.com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数据库访问服务，全局一个即可，由spring帮我们管理
 */
@Component //声明bean
public class JdbcDriverMessageService {
    private final static Log log = LogFactory.getLog(JdbcDriverMessageService.class);

    //此处需要依赖注入，本例通过构造函数注入MessageRepository
    private JdbcDriverMessageRepository repository;

    @Autowired
    public JdbcDriverMessageService(JdbcDriverMessageRepository repository){
        log.info(String.format("***MessageService(构造函数注入repository)***：%s", repository.toString()));
        this.repository = repository;
    }

    public Message save(String text){
        log.info(String.format("***MessageService.save(%s)***: bean=%s", text, this.repository.toString()));
        return this.repository.saveMessage(new Message(text));
    }
}