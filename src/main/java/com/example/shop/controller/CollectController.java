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
        System.out.println("你被访问了");
        VxResp vx = new VxResp();
        vx.collects = collectMapper.select();
        System.out.println(vx.collects);
        return vx;
    }
//    @ResponseBody
//    @RequestMapping("collect/index/vx")
//    public void recollect (int pid,int uid){
//        collectMapper.insert(uid,pid);
//
//    }

    //web显示
    //@ResponseBody
    //@RequestMapping("/alll")
    //public String alll(){
     //   List<CollectBean> list =collectMapper.select();
       // return list.toString();
    //}

//    @ResponseBody
//    @RequestMapping("/del")
//    public String del(int id){
//        // int uid = productMapper.selectById(id).uid;
//        collectMapper.deleteById(id);
//
//        // 重新进入productst.html
//        return null;
//    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(int uid,int id){
        CollectBean bean=new CollectBean();
        bean.uid=uid;
        bean.pid=id;

        collectMapper.insert(bean);

        return null;
    }


}
