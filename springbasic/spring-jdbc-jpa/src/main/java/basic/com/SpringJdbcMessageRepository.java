package basic.com;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;


/**
 * 数据库操作，全局只需要一个即可，由spring帮我们管理再合适不过了。
 */
@Component //声明bean
public class SpringJdbcMessageRepository{
    private final static Log log = LogFactory.getLog(JdbcDriverMessageRepository.class);

    // Spring JDBC provides a layer of abstraction above the JDBC API. 
    // The JdbcTemplate class is the core of this layer，NamedParameterJdbcTemplate是JdbcTemplate的封装。
    // 它们帮助我们管理connection和与jdbc API交互，简化使用。
    private NamedParameterJdbcTemplate jdbcTemplate;
    
    // setter注入
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    // 无需直接使用jdbc API
    public Message saveMessage(Message message){
        log.info(String.format("***saveMessage(%s)***", message.getText()));

        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("text", message.getText());
        params.addValue("createdDate",message.getCreatedDate());
        String insertSQL = "INSERT INTO messages (`id`, `text`,`created_date`) VALUE (null, :text, :createdDate)";

        try {
            this.jdbcTemplate.update(insertSQL, params, holder);
        } catch (DataAccessException ex) {
            log.error("Failed to save message", ex);
            return null;
        }
        
        return new Message(holder.getKey().intValue(), message.getText(), message.getCreatedDate());
    }
}