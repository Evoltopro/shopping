package com.example.shop.controller;

import com.example.shop.bean.CommentBean;
import com.example.shop.bean.ProductBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentMapper commentMapper;

    @ResponseBody    //把对象变成字符
    @RequestMapping("/index/vx")

    public VxResp index(){
        VxResp vx = new VxResp();
//        vx.categorys = categoryMapper.selectList(null);
        vx.comments = commentMapper.list();
//        vx.hots = productMapper.selectHot();
//        if(cid == null && !vx.categorys.isEmpty()){
//            //cid没有，类别数组有
//            cid = vx.categorys.get(0).id;
//        }
//        if(cid == null){
//            //数据库空
//            vx.products = new ArrayList<>();//空商品数组
//
//        } else{ //有类别，按照类别id查询这个类别的商品列表
//            vx.products = productMapper.selectProduct(cid);
//        }
        //格式化工具
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        for(ProductBean bean : vx.products){
//            bean.ftime = sdf.format(bean.ctime); //data ctime-> String ftime
//        }
        return vx;
    }
    // 增、改，查看


    //展示
//    @GetMapping("/list")
//    public String list(HttpServletRequest request){
//        System.out.println(123);
//        List<CommentBean> list = commentMapper.list();
//        request.setAttribute("list",list);
//        return "展示页面";
//    }
    //增加
    //先跳转到增加页面
    @RequestMapping("/add1")
    public String add1(){
        return "增加页面可以";
    }
    @RequestMapping("/add2")
    public String add(CommentBean commentBean){
        commentMapper.add(commentBean);
        return "展示页面";
    }
    //修改
    //跳到修改页面
    @RequestMapping("/update/{id}/{pid}/{uid}/{comment}/{ctime}")
    public String update(@PathVariable("id") int id,
                         @PathVariable("pid")int pid,
                         @PathVariable("uid")int uid,
                         @PathVariable("comment")String comment,
                         @PathVariable("ctime")LocalDateTime localDateTime,
                         HttpServletRequest request){
        CommentBean commentBean = new CommentBean(id,pid,uid,comment,localDateTime);
        System.out.println(commentBean);
        request.setAttribute("commentBean",commentBean);
        return "修改页面";
    }

    @RequestMapping("/update")
    public String update(CommentBean commentbean){
        commentMapper.update(commentbean);
        return "展示页面";
    }
}
