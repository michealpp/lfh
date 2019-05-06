package basic.com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 2. 体现model-view-controller pattern的例子
 * c(controller)
 * m(model):存放由controller生成数据
 * v(view):存放html，并接收model的数据，处理成最终的http response
 */
@Controller
@RequestMapping("/mvcmsgs/")
public class MvcMsgController{

    @GetMapping("/r1")
    public String welcome1(Model model){//model由spring创建并传入
        //准备数据，和模板中的${message}匹配
        model.addAttribute("message", "Hello, Welcome to Spring Boot!");

        //请求路径，即hello.html
        return "hello";
    }

    @GetMapping("/r2")
    public ModelAndView welcome2(){
        //
        ModelAndView mv = new ModelAndView("hello");
        //准备数据
        mv.addObject("message", "Hello, Welcome to Spring Boot!!");
        
        return mv;
    }
}