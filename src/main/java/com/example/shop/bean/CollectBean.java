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

    @NotNull
    public String product;
    @NotNull
    public Integer price;
    //1 把图片通过base64算法转成特别长的字符串
    @NotNull
    public String logo; //2 数据库保存图片保存的是地址

    public Integer uid;//外键 人 卖的人
    public Integer pid;//外键 商品 所属类型id

    //视图
    @TableField(exist=false)
    public String user;
}
