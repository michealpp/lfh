package basic.com;

import java.util.Date;

/**
 * POJO实体类
 */
public class Message{

    private Integer id;
    private String text;
    private Date createdDate;

    public Message(String text){
        this.text = text;
        this.createdDate = new Date();
    }
    public Message(int id, String text, Date createDate){
        this.id = id;
        this.text = text;
        this.createdDate = createDate;
    }

   
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getText(){
        return this.text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}