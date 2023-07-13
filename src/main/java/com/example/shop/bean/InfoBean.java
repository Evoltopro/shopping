package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tbl_info")
public class InfoBean {
    @TableId(type = IdType.AUTO)
    public Integer id;
    @NotNull
    public String info;
    @NotNull
    public String description;
    public Date ctime;

    public Integer uid;
}
