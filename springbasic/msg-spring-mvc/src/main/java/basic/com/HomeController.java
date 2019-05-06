package basic.com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 1.简单的无model-view-controller结构的例子
 */
@Controller
@RequestMapping("/msgs")
public class HomeController{

    @GetMapping("/r1")
    @ResponseBody
    public String welcome1(){
        //返回普通字符串
        return "Hello, welcome!";
    }

    @GetMapping("/r2")
    @ResponseBody
    public String welcome2(){
        //返回html
        return "<strong>Hello, welcome!</strong>";
    }
    
}