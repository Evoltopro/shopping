package com.example.shop.controller;

import com.example.shop.bean.FootBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.FootMapper;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/foot")
public class FootController extends BaseController{
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    FootMapper footMapper;
    @ResponseBody
    @RequestMapping("/all")
    public VxResp all(int uid){
        System.out.println("你被访问了");
        VxResp vx = new VxResp();
        vx.allfoot = footMapper.selectFoot(uid);
        System.out.println(vx.allfoot);
        return vx;
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(int uid,int pid){
        FootBean bean=new FootBean();
        bean.uid=uid;
        bean.pid=pid;
        footMapper.insert(bean);
        return null;
    }
    @ResponseBody
    @RequestMapping("/del")
    public String del(int id){
        System.out.println(id);
        footMapper.deleteById(id);
        return null;
    }
}
