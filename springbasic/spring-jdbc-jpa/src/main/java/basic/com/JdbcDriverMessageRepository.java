package basic.com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;


/**
 * 数据库操作，全局只需要一个即可，由spring帮我们管理再合适不过了。
 */
@Component //声明bean
public class JdbcDriverMessageRepository{
    private final static Log log = LogFactory.getLog(JdbcDriverMessageRepository.class);

    //构造函数注入
    private DataSource dataSource;

    public JdbcDriverMessageRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public Message saveMessage(Message message){
        log.info(String.format("***saveMessage(%s)***", message.getText()));
        Connection conn = DataSourceUtils.getConnection(dataSource);
        try{
            String insertSql = "INSERT INTO messages (`id`, `text`, `created_date`) VALUE (null, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, message.getText());
            ps.setTimestamp(2, new Timestamp(message.getCreatedDate().getTime()));
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                ResultSet result = ps.getGeneratedKeys();
                if(result.next()){
                    int id = result.getInt(1);
                    return new Message(id, message.getText(), message.getCreatedDate());
                }else{
                    log.error("failed to retrieve id");
                    return null;
                }
            }else{
                return null;
            }
        }catch(SQLException ex){
            log.error("failed to save", ex);
            try{
                conn.close();
            }catch(SQLException e){
                log.error("failed to close connection", e);
            }
        }finally{
            DataSourceUtils.releaseConnection(conn, dataSource);
        }
        return null;
    }
}