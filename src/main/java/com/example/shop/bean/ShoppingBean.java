package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

@Data
@TableName("tbl_shopping")
public class ShoppingBean {
    @TableId(type = IdType.AUTO)
    public Integer id; //自动递增主键

    @NotNull
    public Integer count;

    public Integer pid;//外键 商品
    public Integer oid;//外键 订单号


}
