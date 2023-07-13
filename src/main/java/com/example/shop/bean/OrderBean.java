package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@TableName("tbl_order")
public class OrderBean {

    @TableId(type = IdType.AUTO)
    public Integer id; //自动递增主键

    @NotNull
    public String name;
    @NotNull
    public String mobile;

    @NotNull
    public String address;
    @NotNull
    public Integer total; //总价
    @NotNull
    public Date ctime; //下单时间

    @NotNull
    public Integer uid;//外键 人 买的人


    @TableField(exist = false) //数据库中没有
    public Integer count; //默认空

    @TableField(exist = false) //数据库中没有
    public String ftime; //默认空

    @TableField(exist = false) //数据库中没有
    public Integer pid; //默认空


    @TableField(exist = false) //数据库中没有
    public Integer price; //默认空
}
