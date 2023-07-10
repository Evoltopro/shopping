package com.example.shop.controller;

import com.example.shop.mapper.CategoryMapper;
import com.example.shop.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryMapper categoryMapper;

    //selectList(null);查询表所有数据，得到一个List
    //ArrayList让数组添加、删除数据

    // localhost:8080/list
    @RequestMapping("/list")
    public String list(HttpServletRequest req){
        System.out.println("进入到list中");
        req.setAttribute("retList",productMapper.selectList(null));
        return "/product/list";
    }

    @RequestMapping("/del")   //删除
    public String del(int id){
        productMapper.deleteById(id);
        return "redirect:/product/list"; //传到上边重新查询
    }

    //product/add
    @GetMapping ("/add")
    public String add(Integer id,HttpServletRequest req){

        req.setAttribute("cateList",categoryMapper.selectList(null));
        req.setAttribute("bean",id == null?null:productMapper.selectById(id));

        return "/product/add";//转发到templates/product/add.html
    }
    @PostMapping("/add") //RequestMapping 什么类型都能进
    public String add(){
//        System.out.println("表单进来");
        return null;
    }
    //get <a></>,重定向 浏览器网址 最不安全
    //post 写代码访问 安全级低
}
