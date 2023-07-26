package com.china.web;

import com.china.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ExampleController {

    @RequestMapping("/string")
    public String string(ModelMap map) {
        map.addAttribute("userName", "小红");
        return "string";
    }

    @RequestMapping("/getUser")
    public String getUser(ModelMap map){
        User user = new User("技术大牛",30,"123");
        map.addAttribute("user",user);
        return "user";
    }

    @RequestMapping("/if")
    public String ifunless(ModelMap map) {
        map.addAttribute("flag", "yes");
        return "if";
    }

    @RequestMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("users", getUserList());
        return "list";
    }

    @RequestMapping("/url")
    public String url(ModelMap map) {
        map.addAttribute("type", "java.html");
        map.addAttribute("pageId", "cxy521");
        map.addAttribute("img", "https://www.cxy521.com/static/img/java/basic/spring.png");
        return "url";
    }

    @RequestMapping("/eq")
    public String eq(ModelMap map) {
        map.addAttribute("name", "小明");
        map.addAttribute("age", 30);
        map.addAttribute("flag", "yes");
        return "eq";
    }

    @RequestMapping("/switch")
    public String switchcase(ModelMap map) {
        map.addAttribute("sex", "woman");
        return "switch";
    }

    private List<User> getUserList(){
        List<User> list=new ArrayList<User>();
        User user1=new User("大牛",12,"123456");
        User user2=new User("小牛",6,"123563");
        User user3=new User("编程神牛",66,"666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return  list;
    }

    @RequestMapping("/inline")
    public String inline(ModelMap map) {
        map.addAttribute("userName", "admin");
        return "inline";
    }

    @RequestMapping("/object")
    public String object(HttpServletRequest request,ModelMap map) {
        request.setAttribute("reqParam","i am request");
        request.getSession().setAttribute("userName","i am session");

        map.addAttribute("request",request);
        map.addAttribute("session",request.getSession());
        return "object";
    }

    @RequestMapping("/utility")
    public String utility(ModelMap map) {
        map.addAttribute("userName", "admin");
        map.addAttribute("users", getUserList());
        map.addAttribute("count", 12);
        map.addAttribute("date", new Date());
        return "utility";
    }
}
