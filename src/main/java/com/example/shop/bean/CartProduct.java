package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.TableField;

public class CartProduct extends ProductBean{

    @TableField(exist = false)
    public Integer count;
}
