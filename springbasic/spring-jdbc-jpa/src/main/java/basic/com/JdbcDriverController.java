package basic.com;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/msg/jdbc")
public class JdbcDriverController{

    private JdbcDriverMessageService messageService;

    public JdbcDriverController(JdbcDriverMessageService messageService){
        this.messageService = messageService;
    }

    /**
     * 返回值类型为Spring ResponseEntity<>，它允许我们设置response status, body, and headers。
     * @RequestBody把http request body里的json转化成java对象
     */
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Message> saveMessage(@RequestBody MessageData data){
        Message saved = messageService.save("[JDBC API] " + data.getText());
        if (saved == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(saved);
    }

}