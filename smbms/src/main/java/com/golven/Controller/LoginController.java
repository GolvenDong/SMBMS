package com.golven.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.golven.mapper.UserMapper;
import com.golven.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/loginController")
    public String show(Model model,
                       @RequestParam(defaultValue = "") String userCode,
                       @RequestParam(defaultValue = "") String userPassword
    ){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userCode",userCode);
        wrapper.eq("userPassword",userPassword);
        User user = userMapper.selectOne(wrapper);
        System.out.println(userCode);
        System.out.println(userPassword);
        if (user!=null){
            model.addAttribute("user",user);
            System.out.println(user);
            return "frame";
        }else {
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

}