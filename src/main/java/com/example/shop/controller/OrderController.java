package com.example.shop.controller;

import com.example.shop.bean.OrderBean;

import com.example.shop.bean.ProductBean;
import com.example.shop.bean.ShoppingBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.CartMapper;
import com.example.shop.mapper.CategoryMapper;
import com.example.shop.mapper.OrderMapper;

import com.example.shop.mapper.ShoppingMapper;
import com.example.shop.util.NotNullUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    ShoppingMapper shoppingMapper;

    //订单展示
    @ResponseBody    //把对象变成字符
    @RequestMapping("/index/vx")
    public VxResp shopp(){
//        System.out.println(bean.name);
        VxResp vx = new VxResp();

        vx.orders = orderMapper.select();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for(OrderBean bean : vx.orders){
            bean.ftime = sdf.format(bean.ctime); //data ctime-> String ftime
        }

        return vx;
    }

    //订单插入
    @ResponseBody
    @RequestMapping("/add/vx")
    public void order(OrderBean bean){

        System.out.println(bean.pid);
        Integer total = 0;
        total = bean.count * bean.price;


        bean.ctime = new Date();
        bean.total = total;

        System.out.println(bean);


        orderMapper.insertA(bean.name,bean.mobile,bean.address,bean.total,bean.ctime,bean.uid);

//        orderMapper.insert(bean);
//        ShoppingBean shop = new ShoppingBean();
//        shop.count = bean.count;
//        shop.oid = bean.id;
//        shop.pid = bean.pid;
//        shoppingMapper.insert(shop.count,shop.pid,shop.oid);
        shoppingMapper.insert(bean.count,bean.pid,2);


        cartMapper.delete(bean.pid);

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
