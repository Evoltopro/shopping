package com.example.shop.controller;

import com.example.shop.bean.OrderBean;
import com.example.shop.bean.UserBean;
import com.example.shop.bean.VxResp;
import com.example.shop.mapper.OrderMapper;
import com.example.shop.mapper.ProductMapper;
import com.example.shop.util.NotNullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseController{

    @Autowired
    OrderMapper orderMapper;

    @ResponseBody // 把java对象转成字符串
    @RequestMapping("/order/vx")
    public VxResp order(OrderBean bean){
        System.out.println(bean.name);

        VxResp vx = new VxResp();
        if(NotNullUtil.isBlank(bean)){
            vx.fail("请完善信息");
            return vx;
        }


        orderMapper.insert(bean);
        vx.uid = String.valueOf(bean.id);


        return vx;
    }



    @RequestMapping("/list")  //查询列表
    public String list(int uid, HttpServletRequest req) {
        System.out.println("进入到orderlist中");
        req.setAttribute("retList", orderMapper.selectOrderUser(uid));
        return "/order/list";


    }
}
