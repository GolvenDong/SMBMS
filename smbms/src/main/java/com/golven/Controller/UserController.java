package com.golven.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.golven.mapper.UserMapper;
import com.golven.pojo.User;
import com.golven.pojo.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserMapper userMapper;

    //分页查询用户信息，兼具模糊搜索功能
    @SneakyThrows
    @RequestMapping("/showUserList")
    public String showUserList(Model model,
                               @RequestParam(defaultValue = "") String userNameSearch,
                               @RequestParam(defaultValue = "1") Integer pageNo,
                               @RequestParam(defaultValue = "4") Integer pageSize) {
        //搜索框输入的内容
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("userName", userNameSearch);

        Page<User> page = new Page<>(pageNo,pageSize);
        userMapper.selectPage(page, wrapper);
        Getage getage = new Getage();
        List<Integer> ageList = new ArrayList<>();
        int i = 0;
        for (User record : page.getRecords()) {
            System.out.println(record);
            System.out.println(getage.getAge(record.getBirthday()));
            ageList.add(i,getage.getAge(record.getBirthday()));
            i++;
        }
        model.addAttribute("users", page.getRecords());
        model.addAttribute("age", ageList);

        Map<String,Integer> map = new HashMap<>();
        map.put("pageNo", pageNo);
        map.put("pages", (int)page.getPages());
        model.addAttribute("page", map);
        System.out.println(map);
        return "userList";
    }

    //跳转到添加用户界面
    @RequestMapping("/addAUser")
    public String addAUser() {
        //进入userAdd.html页面
        return "userAdd";
    }

    //执行添加用户
    @RequestMapping("/addUser")
    public String addUser(User user) {
        System.out.println(user);
        userMapper.insert(user);
        //进入userList.html页面
        return "redirect:/user/showUserList";
    }

    //跳转到用户详细信息界面
    @SneakyThrows
    @RequestMapping("/showUser")
    public String showUser(Model model,
                           @RequestParam int id,
                           @RequestParam int age) {
        User user = userMapper.selectById(id);
        model.addAttribute("age", age);
        model.addAttribute("user", user);
        return "userView";
    }

    //跳转到修改用户信息界面
    @RequestMapping("/updateAUser")
    public String updateAUser(int id, Model model) {
        User user = userMapper.selectById(id);
        model.addAttribute("user", user);
        return "userUpdate";
    }

    //执行修改用户信息
    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        System.out.println(user);
        userMapper.updateById(user);
        return "redirect:/user/showUserList";
    }

    //执行删除用户
    @RequestMapping("/deleteUser")
    public String deleteUser(int id) {
        userMapper.deleteById(id);
        return "redirect:/user/showUserList";
    }
    @RequestMapping("/toupdatePwd")
    public String updatePwd(Model model,HttpServletRequest request){
        String id = request.getParameter("id");
        System.out.println("id"+id);
//        User user = userMapper.selectById(id);
        System.out.println("登录的user+"+id);
        model.addAttribute("id",id);
        return "updatePwd";
    }
    @RequestMapping("logOut")
    public String logOut(HttpSession session, SessionStatus sessionStatus){
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/login";
    }
    @ResponseBody
    @RequestMapping("/updatePwd")
    public String updatePwd(String oldPwd,String newPwd,String id){
        System.out.println(oldPwd+"  "+newPwd+"   "+id);
        User user = userMapper.selectById(id);
        if(oldPwd.equals(user.getUserPassword())){
            user.setUserPassword(newPwd);
            int i = userMapper.updateById(user);
            if(i>0){
                return "success";
            }else {
                return "false";
            }
        }else {
            return "false";
        }

    }
}
