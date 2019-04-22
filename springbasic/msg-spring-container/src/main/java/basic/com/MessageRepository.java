package basic.com;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 数据库操作
 */
public class MessageRepository{
    private final static Log log = LogFactory.getLog(MessageRepository.class);

    public void saveMessage(Message message){
        log.info(String.format("Saved message: %s", message.getText()));
    }
}