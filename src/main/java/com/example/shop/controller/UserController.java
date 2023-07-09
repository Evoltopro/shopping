package com.example.shop.controller;


import com.example.shop.bean.UserBean;
import com.example.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller  //使这个类成为控制器
public class UserController {
    @Autowired
    UserMapper userMapper;

    // http://localhost:8080/login?username=xxx&password
    @RequestMapping("/login")
    public String login(UserBean bean, HttpServletRequest req) throws Exception {
        UserBean user = userMapper.getUser(bean.username,bean.password);
        if(user == null) {
            System.out.println("wrong");
            return "redirect:/index.html?msg=" + URLEncoder.encode("用户名或密码错误" , "utf-8");
        } else {
            System.out.println("成功登录");
            req.setAttribute("user",user);
            return "/main";
        }

    }
}
