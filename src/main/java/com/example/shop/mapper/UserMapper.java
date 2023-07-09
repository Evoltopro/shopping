package com.example.shop.mapper;

import com.example.shop.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Mapper MyBabatis区域 写sql语句的地方
@Repository
public interface UserMapper {

//    @Autowired
//    UserBean userbean;

    //接口：方法抽象，默认public                         #{}取值
    @Select("select * from tbl-user where username = #{username} and password = #{password}")
    UserBean getUser(@Param("username") String username,
                     @Param("password") String password);
    //编译时会改形参名字
}
