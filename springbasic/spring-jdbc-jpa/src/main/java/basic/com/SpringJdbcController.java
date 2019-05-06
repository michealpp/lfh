package basic.com;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/msg/sjdbc")
public class SpringJdbcController{
    private SpringJdbcMessageService msgService;

    public SpringJdbcController(SpringJdbcMessageService msgService){
        this.msgService = msgService;
    }

    @PostMapping("/add")
    public ResponseEntity<Message> addMessage(@RequestBody MessageData data){
        Message saved = msgService.save("[SpringJDBC] " + data.getText());
        if (saved == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(saved);
    }
}