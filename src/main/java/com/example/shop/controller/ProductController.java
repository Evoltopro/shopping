package com.example.shop.controller;

import com.example.shop.bean.ProductBean;
import com.example.shop.mapper.CategoryMapper;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.util.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{
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
    public String add(ProductBean bean, HttpServletResponse resp){
        //判断空
        if(NotNullUtil.isBlank(bean)){
            return jsAlert("请完善信息!",resp);
        }
//        System.out.println("表单进来");
        if(bean.id == null) {
            bean.ctime = new Date(); //当前时间，上架时间
            productMapper.insert(bean);
        } else{
            productMapper.updateById(bean);
        }
        return "redirect:/product/list";
    }
    //get <a></>,重定向 浏览器网址 最不安全
    //post 写代码访问 安全级低
}
