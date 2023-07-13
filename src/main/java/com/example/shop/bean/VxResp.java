package com.example.shop.bean;

import java.util.List;

//为小程序准备，返回小程序的数据都在此定义
public class VxResp {

    public int code = 1;  //响应码 1成功 0失败
    public String msg = ""; //错误提示语

    //失败函数
    public void fail(String msg){
        this.code = 0;
        this.msg = msg;
    }

    public String  uid = "";  //返回uid给小程序

    public List<CategoryBean> categorys;
    public List<ProductBean> hots; // 数组

    public List<ProductBean> products;

    public List<CommentBean> comments;

    public List<InfoBean> infos;


}
