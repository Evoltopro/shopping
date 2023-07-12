package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tbl_comment")
public class CommentBean {

    @TableId(type = IdType.AUTO)
    public Integer id; //自动递增主键

    @NotNull
    public Integer pid;
    @NotNull
    public Integer uid;

    @NotNull
    public String comment;
    public Date ctime; //下单时间


}
