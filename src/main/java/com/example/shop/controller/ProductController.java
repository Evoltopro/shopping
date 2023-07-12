package com.example.shop.controller;

import com.example.shop.bean.ProductBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.CategoryMapper;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.util.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @ResponseBody    //把对象变成字符
    @RequestMapping("/index/vx")
    public VxResp index(Integer cid){
        VxResp vx = new VxResp();
        vx.categorys = categoryMapper.selectList(null);
        vx.hots = productMapper.selectHot();
        if(cid == null && !vx.categorys.isEmpty()){
            //cid没有，类别数组有
            cid = vx.categorys.get(0).id;
        }
        if(cid == null){
            //数据库空
            vx.products = new ArrayList<>();//空商品数组

        } else{ //有类别，按照类别id查询这个类别的商品列表
            vx.products = productMapper.selectProduct(cid);
        }
        //格式化工具
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for(ProductBean bean : vx.products){
            bean.ftime = sdf.format(bean.ctime); //data ctime-> String ftime
        }
        return vx;
    }

    //selectList(null);查询表所有数据，得到一个List
    //ArrayList让数组添加、删除数据

    // localhost:8080/product/list?uid =
    @RequestMapping("/all")
    public String all(HttpServletRequest req){ //查询视图数据
        req.setAttribute("retList",productMapper.selectView());
        return "/product/all";
    }
    @RequestMapping("/list")  //查询列表
    public String list(int uid,HttpServletRequest req){
        System.out.println("进入到list中");
        req.setAttribute("retList",productMapper.selectList(uid));
        return "/product/list";
    }

    @RequestMapping("/del")   //删除
    public String del(int id){
        int uid = productMapper.selectById(id).uid;
        productMapper.deleteById(id);
        return "redirect:/product/list?uid=" + uid; //传到上边重新查询
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
        return "redirect:/product/list?uid=" + bean.uid;
    }
    //get <a></>,重定向 浏览器网址 最不安全
    //post 写代码访问 安全级低
}
