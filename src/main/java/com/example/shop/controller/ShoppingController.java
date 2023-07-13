package com.example.shop.controller;

import com.example.shop.bean.VxResp;
import com.example.shop.mapper.ShoppingMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Data
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    ShoppingMapper shoppingMapper;

    @ResponseBody
    @RequestMapping("/index/vx")
    public VxResp shopping(){
        VxResp vx = new VxResp();

        return vx;
    }


    @RequestMapping("/add/vx")
    public void add(Integer id){

    }
}
