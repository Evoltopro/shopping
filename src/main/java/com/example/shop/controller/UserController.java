package com.example.shop.controller;


import com.example.shop.bean.UserBean;
import com.example.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  //使这个类成为控制器
public class UserController {
    @Autowired
    UserMapper userMapper;

    // http://localhost:8080/login?username=xxx&password
    @RequestMapping("/login")
    public String login(UserBean bean){
        UserBean user = userMapper.getUser(bean.username,bean.password);
        if(user == null) {
            System.out.println("wrong");
            return "redirect:/index.html?msg=error";
        }else {
            System.out.println("成功登录");
            return "???";
        }

    }
}
