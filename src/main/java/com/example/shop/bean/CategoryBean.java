package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_category")
public class CategoryBean {

    @TableId(type = IdType.AUTO)
    public Integer id;
    public String category;
}
