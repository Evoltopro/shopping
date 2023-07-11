package com.example.shop.bean;
//普通类--数据表

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shop.util.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //生成get set
//set get -> freemarker选入按数据时必须要用
@AllArgsConstructor
@NoArgsConstructor

@TableName("tbl_user")
public class UserBean {
    //
    @TableId(type = IdType.AUTO) //id自动递增，与数据表对应
    public Integer id; //不用int，integer包装类，可接收Null
    @NotNull
    public String username;
    @NotNull
    public String password;
    public String user;
    public String status;
    public String store;

}
