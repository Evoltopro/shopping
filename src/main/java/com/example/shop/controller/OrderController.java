package com.example.shop.controller;

import com.example.shop.bean.OrderBean;

import com.example.shop.bean.ProductBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.CategoryMapper;
import com.example.shop.mapper.OrderMapper;

import com.example.shop.util.NotNullUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
    @Autowired
    OrderMapper orderMapper;

    //订单展示
    @ResponseBody    //把对象变成字符
    @RequestMapping("/index/vx")
    public VxResp order(){
//        System.out.println(bean.name);
        VxResp vx = new VxResp();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for(OrderBean bean : vx.orders){
            bean.ftime = sdf.format(bean.ctime); //data ctime-> String ftime
        }
        //bean.ctime = new Date(); //当前时间，上架时间
        //orderMapper.insert(bean);

        return vx;
    }

    //订单插入
    @ResponseBody
    @RequestMapping("/find/vx")
    public VxResp order(OrderBean bean,Integer count){
        System.out.println(bean);
        System.out.println(count);
        VxResp vx = new VxResp();

        //bean.ctime = new Date(); //当前时间，上架时间
        //orderMapper.insert(bean);

        return vx;

    }


    @RequestMapping("/list")  //查询列表
    public String list(HttpServletRequest req){
        req.setAttribute("retList",orderMapper.selectOrder());
        return "/order/list";
    }

    @RequestMapping("/del")   //删除
    public String del(int id){
        System.out.println(id);
        orderMapper.delete(id);
        return "redirect:/order/list"; //传到上边重新查询
    }

}
