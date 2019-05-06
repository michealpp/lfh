package basic.com;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * DDL：Data Definition Language
 * metadata指定类与表如何映射
 * hibernate Entity类需要有默认构造函数
 * @javax.persistence.Entity标记该类为Entity类
 * @javax.persistence.Table标记类映射的DB表
 * @javax.persistence.Id标记entity的主键
 * @javax.persistence.GeneratedValue标记值如何生成，strategy = GenerationType.IDENTITY标识由DB为我们生成，这和DB表中该字段定义为AUTO_INCREMENT是匹配的。
 * @javax.persistence.Column标记该field映射的column, nullable=false标记column不为空，length指定column数据长度
 * @javax.persistence.Temporal当field的类型为java.util.Date 或 java.util.Calendar类型时需要，TemporalType.TIMESTAMP表示createdDate field映射为JDBC driver能理解的java.sql.Timestamp类型
 * 
 * Hibernate won't perform a data validation based on the nullable setting and the length attribute of the @Column annotation.
 */
@Entity
@Table(name="messages")
public class MessageEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)  
    private Integer id;

    @Column(name = "text", nullable = false, length = 128)
    private String text;

    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public MessageEntity(){
        
    }

    public MessageEntity(String text) {
        this.text = text;
        this.createdDate = new Date();
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