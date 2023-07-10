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
        UserBean user = userMapper.getUser(bean);
        if(user == null) {
            System.out.println("wrong");
            return "redirect:/index.html?msg=" + URLEncoder.encode("用户名或密码错误" , "utf-8");//重定向
        } else {
//            System.out.println("成功登录");
//            req.setAttribute("user",user);//带参数转发，网页${}渲染带过来的数据
//            return "/main";  //转发，打开templates中的网页，里面的网页只能通过Java处理，转发打开
              return "redirect:/main?uid=" + user.id; //重定向实现
        }
    }

    @RequestMapping("/main") //Request 转发代参
    public String main(int uid,HttpServletRequest req){
        System.out.println("打印" + uid);
        //按照id插叙这条记录
        req.setAttribute("user",userMapper.selectById(uid));
        return "/main"; //不加.html后缀
    }
    //重定向：重新刷新网页，是浏览器的行为，地址会改变,一般使用重定向进入java地
    //转发是java行为

}
