package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tbl_collect")
public class CollectBean {
    @TableId(type = IdType.AUTO)
    public Integer id; //自动递增主键

    @TableField(exist=false)
    public String product;
    @TableField(exist=false)
    public Integer price;

    public Integer uid;
    public Integer pid;

    //视图
    @TableField(exist=false)
    public String logo;
}
