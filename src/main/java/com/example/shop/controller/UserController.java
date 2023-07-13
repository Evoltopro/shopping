package com.example.shop.controller;


import com.example.shop.bean.UserBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.UserMapper;
import com.example.shop.util.FileUtil;
import com.example.shop.util.NotNull;
import com.example.shop.util.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller  //使这个类成为控制器
public class UserController {
    @Autowired
    UserMapper userMapper;

    @ResponseBody // 把java对象转成字符串
    @RequestMapping("/login/vx")
    public VxResp login(UserBean bean)
    {
//        System.out.println(bean.username);
//        System.out.println(bean.password);
        VxResp vx = new VxResp();
        if(NotNullUtil.isBlank(bean)){
            vx.fail("请完善信息");
            return vx;
        }

        bean.status = "买家";
        if(userMapper.haveUser(bean.username) != null){//账号存在
            UserBean user = userMapper.getUser(bean);
            if(user == null) {
                vx.fail("密码错误");
            }else{
                //登陆成功的id返给小程序
                vx.uid = String.valueOf(user.id);
            }
        } else{//没有账号
            bean.user = bean.username; //完善昵称
            userMapper.insert(bean);   // 新人注册到用户表中
            vx.uid = String.valueOf(bean.id);
        }
        return vx; //把对象转成字符串返回给java
    }

    // http://localhost:8080/login?username=xxx&password
    @RequestMapping("/login")
    public String login(UserBean bean, HttpServletRequest req) throws Exception {
        bean.status = "卖家";
        UserBean user = userMapper.getUser(bean);
        if(user == null) {
            System.out.println("用户名或密码错误");
            return "redirect:/index.html?msg=" + URLEncoder.encode("用户名或密码错误" , "utf-8");//重定向
        } else {
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

    @ResponseBody //底层为json 将字符串返回给网页
    @RequestMapping("/upload") //Tomcat吸收错误
    public String upload(MultipartFile file) throws Exception{
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        //保存到file
        FileUtil.createFile("D:/create/shop/upload");
        file.transferTo(new File("D:/create/shop/upload/"+ fileName));
        return "/shop/upload/" + fileName; //3.将这个字符串返回到网站
    }

    @RequestMapping("/yanzhengma")
    public String yanzheng(String phone){
        System.out.println("验证码");
        return "验证码";
    }
}
