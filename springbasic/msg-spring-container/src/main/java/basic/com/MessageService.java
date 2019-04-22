package basic.com;


/**
 * 数据库访问服务
 */
public class MessageService {
    private MessageRepository repository;

    public MessageService(MessageRepository repository){
        this.repository = repository;
    }

    public void save(String text){
        System.out.println(String.format("repository bean: %s", this.repository.toString()));
        this.repository.saveMessage(new Message(text));
    }
}