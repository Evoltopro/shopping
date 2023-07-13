package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@TableName("/tbl_cart")
public class CartBean {
    @TableId(type = IdType.AUTO)
    public Integer id; //自动递增主键

    @NotNull
    public Integer count;//外键 人 买的人

    @NotNull
    public Integer pid;//商品

    @NotNull
    public Integer uid;//外键 人 买的人

    @TableField(exist = false) //数据库中没有
    public Integer price;

    @TableField(exist = false) //数据库中没有
    public String user;

}
