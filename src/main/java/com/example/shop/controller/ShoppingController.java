package com.example.shop.controller;

import com.example.shop.bean.CommentBean;
import com.example.shop.bean.ShoppingBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.ShoppingMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    ShoppingMapper shoppingMapper;

    @ResponseBody
    @RequestMapping("/index/vx")
    public VxResp shopping(){
        VxResp vx = new VxResp();

        vx.shoppings = shoppingMapper.select();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for(ShoppingBean bean: vx.shoppings){
            bean.ftime = sdf.format(bean.ctime); //data ctime-> String ftime
        }

        return vx;
    }

}
