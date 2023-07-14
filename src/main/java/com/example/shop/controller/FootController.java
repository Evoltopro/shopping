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

import java.util.Date;

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
    public VxResp all(){

        VxResp vx = new VxResp();
        vx.allfoot = footMapper.selectFoot();
        System.out.println(vx.allfoot);
        return vx;
    }

    @ResponseBody
    @RequestMapping("/add")
    public VxResp add(int uid,int id){
        VxResp vx = new VxResp();
        System.out.println(uid+ " "+ id);
//
        FootBean bean=new FootBean();
        bean.uid=uid;
        bean.pid=id;
        bean.ctime= new Date();
        footMapper.insertA(bean.uid,bean.pid,bean.ctime);
        return vx;
    }
    @ResponseBody
    @RequestMapping("/del")
    public String del(int id){
        System.out.println(id);
        footMapper.deleteById(id);
        return null;
    }
}
