package com.example.shop.controller;
import com.example.shop.bean.CollectBean;
import com.example.shop.bean.ProductBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.CollectMapper;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.mapper.UserMapper;
import org.apache.commons.collections.collection.PredicatedCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


//收藏表，里面对应着编号。
@Controller
@RequestMapping("/collect")
public class CollectController extends BaseController{
    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;

    @Autowired
    CollectMapper collectMapper;

    @ResponseBody
    @RequestMapping("/all")
    public VxResp all(){

        VxResp vx = new VxResp();
        vx.collects = collectMapper.select();
        //System.out.println(vx.collects);
        return vx;
    }


    @ResponseBody
    @RequestMapping("/add")
    public VxResp add(int uid,int id){
        VxResp vx = new VxResp();
        CollectBean bean=new CollectBean();
        bean.uid=uid;
        bean.pid=id;

        System.out.println(id+"  "+uid);
        collectMapper.insertA(bean.pid,bean.uid);

        return vx;
    }


}
