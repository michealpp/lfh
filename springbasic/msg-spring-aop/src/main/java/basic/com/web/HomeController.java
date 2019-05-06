package basic.com.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import basic.com.model.Message;
import basic.com.service.MessageService;

@Controller
@RequestMapping("/msg/aop")
public class HomeController{
    private MessageService msgService;

    public HomeController(MessageService msgService){
        this.msgService = msgService;
    }

    @PostMapping("/add")
    public ResponseEntity<Message> addMessage(@RequestBody MessageParam data){
        Message saved = msgService.save("[ORM] " + data.getText());
        if (saved == null) {
            return ResponseEntity.status(500).build();
        }
        return ResponseEntity.ok(saved);
    }
}