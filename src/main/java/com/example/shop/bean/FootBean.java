package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

import java.util.Date;
@Data
@TableName("tbl_foot")
public class FootBean {
    @TableId(type = IdType.AUTO)
    public Integer id; //自动递增主键


    public Integer uid;//外键 人 买的人
    public Integer pid;//外键 产品

    public Date ctime;

    //视图

    @TableField(exist=false)
    public String product;

    @TableField(exist = false) //数据库中没有
    public String ftime; //默认空

    @TableField(exist = false) //数据库中没有
    public String logo; //默认空
}
