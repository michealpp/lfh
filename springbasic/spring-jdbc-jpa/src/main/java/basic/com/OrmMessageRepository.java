package basic.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class OrmMessageRepository{
    //注入SessionFactory
    private SessionFactory sessionFactory;

    public OrmMessageRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public MessageEntity saveMessage(MessageEntity message){
        //通过SessionFactory获取session
        Session session = sessionFactory.openSession();
        session.save(message);
        return message;
    }
}