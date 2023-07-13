package com.example.shop.controller;

import com.example.shop.bean.CommentBean;
import com.example.shop.bean.ProductBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.CommentMapper;
import lombok.Data;
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
import java.util.Date;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for(CommentBean bean: vx.comments){
            bean.ftime = sdf.format(bean.ctime); //data ctime-> String ftime
        }
        return vx;
    }
    // 增、改，查看


    //展示
    @RequestMapping("/list")
    public String list(HttpServletRequest request){
        System.out.println(123);
        List<CommentBean> list = commentMapper.list();
        request.setAttribute("retList",list);
        return "/comment/comment";
    }
    //增加
    //先跳转到增加页面
//    @RequestMapping("/add1")
//    public String add1(){
//        return "增加页面可以";
//    }
    @ResponseBody
    @RequestMapping("/add2")
    public void add(CommentBean commentBean){
        System.out.println(commentBean);
        commentBean.pid=commentBean.id;
        Date date = new Date();
        commentBean.setCtime(date);
        commentMapper.add(commentBean);
//        return "展示页面";
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
       //CommentBean commentBean = new CommentBean(id,pid,uid,comment,localDateTime);
        //System.out.println(commentBean);
        //request.setAttribute("commentBean",commentBean);
        return "修改页面";
    }

    @RequestMapping("/update")
    public String update(CommentBean commentbean){
        commentMapper.update(commentbean);
        return "展示页面";
    }
}
