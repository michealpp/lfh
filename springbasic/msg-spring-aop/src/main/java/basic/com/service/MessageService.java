package basic.com.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import basic.com.model.Message;
import basic.com.repository.MessageRepository;
import basic.com.security.SecurityCheck;

/**
 * 数据库访问服务，全局一个即可，由spring帮我们管理
 */
@Component //声明bean
public class MessageService {
    private final static Log log = LogFactory.getLog(MessageService.class);

    //此处需要依赖注入，本例通过构造函数注入MessageRepository
    private MessageRepository repository;

    @Autowired
    public MessageService(MessageRepository repository){
        log.info(String.format("***MessageService(构造函数注入repository)***：%s", repository.toString()));
        this.repository = repository;
    }

    @SecurityCheck
    public Message save(String text){
        log.info(String.format("***MessageService.save(%s)***: bean=%s", text, this.repository.toString()));
        return this.repository.saveMessage(new Message(text));
    }
}