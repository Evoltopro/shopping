package com.example.shop.controller;

import com.example.shop.bean.CartBean;
import com.example.shop.bean.OrderBean;
import com.example.shop.bean.ProductBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.CartMapper;
import com.example.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartMapper cartMapper;

    @Autowired
    ProductMapper productMapper;
    List<ProductBean> list = new ArrayList<>();

    @ResponseBody
    @RequestMapping("/cart/vx")
    public void add(ProductBean bean,Integer uid){


        bean = productMapper.selectById(bean.id);

        //System.out.println(uid);
        //System.out.println(bean);
        cartMapper.insert(bean.id,uid);

    }
    @ResponseBody    //把对象变成字符
    @RequestMapping("/index/vx")   //返回网页

    public VxResp index(){
        VxResp vx = new VxResp();

        vx.carts=cartMapper.select();
        //System.out.println(vx.carts);
        return vx;
    }

}
