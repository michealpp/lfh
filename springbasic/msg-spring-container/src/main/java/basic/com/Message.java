package basic.com;

/**
 * POJO实体类
 */
public class Message{

    private String text;

    public Message(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }
}