package com.example.shop.controller;

import com.example.shop.bean.VxResp;
import com.example.shop.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//求购信息
@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    InfoMapper infoMapper;

    @ResponseBody    //把对象变成字符
    @RequestMapping("/index/vx")

    public VxResp index(){
        VxResp vx = new VxResp();
        vx.infos=infoMapper.list();
        return vx;
    }

    @RequestMapping("/list")  //查询列表
    public String list(HttpServletRequest req){
        req.setAttribute("retList",infoMapper.list());
        return "/info/info";
    }

    @RequestMapping("/del")   //删除
    public String del(int id){
        infoMapper.delete(id);
        return "redirect:/info/list"; //传到上边重新查询
    }

}
