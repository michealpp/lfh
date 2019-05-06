package basic.com.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import basic.com.model.Message;

@Component
public class MessageRepository{
    //注入SessionFactory
    private SessionFactory sessionFactory;

    public MessageRepository(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Message saveMessage(Message message){
        //通过SessionFactory获取session
        Session session = sessionFactory.openSession();
        session.save(message);
        return message;
    }
}