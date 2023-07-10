package com.example.shop.controller;

import com.example.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductMapper productMapper;

    //selectList(null);查询表所有数据，得到一个List
    //ArrayList让数组添加、删除数据

    // localost:8080/list
    @RequestMapping("/list")
    public String list(HttpServletRequest req){
        System.out.println("进入到list中");
        req.setAttribute("retList",productMapper.selectList(null));
        return "/product/list";
    }
}
