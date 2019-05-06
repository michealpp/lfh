package basic.com;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/msg/orm")
public class OrmController{
    private OrmMessageService msgService;

    public OrmController(OrmMessageService msgService){
        this.msgService = msgService;
    }

    @PostMapping("/add")
    public ResponseEntity<MessageEntity> addMessage(@RequestBody MessageData data){
        MessageEntity saved = msgService.save("[ORM] " + data.getText());
        if (saved == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(saved);
    }
}