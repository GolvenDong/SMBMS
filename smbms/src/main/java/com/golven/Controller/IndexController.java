package com.golven.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/top",method = RequestMethod.GET)
    public String top(Model model, HttpServletRequest request){
        String userName = request.getParameter("userName");
        model.addAttribute("userName",userName);
        return "top";
    }
    @RequestMapping(value="/left",method = RequestMethod.GET)
    public String left(Model model, HttpServletRequest request){
        String id = request.getParameter("id");
        model.addAttribute("id",id);
        return "left";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
//    @RequestMapping("/top")
//    public String top(){
//        return "top";
//    }

}
