package com.example.shop.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


import java.util.Date;

@Data
@TableName("tbl_comment")
@ToString
public class CommentBean {
    @TableId(type = IdType.AUTO)
    public Integer id;
    public Integer pid;
    public Integer uid;
    public String comment;
    public Date ctime;


    @TableField(exist = false)
    public String product;

    @TableField(exist = false)
    public String username;

    @TableField(exist = false) //数据库中没有
    public String ftime; //默认空

}
