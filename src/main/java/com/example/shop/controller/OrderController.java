package com.example.shop.controller;

import com.example.shop.bean.OrderBean;

import com.example.shop.bean.VxResp;
import com.example.shop.mapper.CategoryMapper;
import com.example.shop.mapper.OrderMapper;

import com.example.shop.util.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
    @Autowired
    OrderMapper orderMapper;


    @ResponseBody    //把对象变成字符
    @RequestMapping("/order/vx")
    public void order(OrderBean bean){
        System.out.println(bean.name);
        VxResp vx = new VxResp();
        orderMapper.insert(bean);

    }


    @RequestMapping("/list")  //查询列表
    public String list(HttpServletRequest req){
        req.setAttribute("retList",orderMapper.selectOrder());
        return "/order/list";
    }

    @RequestMapping("/del")   //删除
    public String del(int id){
        orderMapper.delete(id);
        return "redirect:/order/list"; //传到上边重新查询
    }

}
