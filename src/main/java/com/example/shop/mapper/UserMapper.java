package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//Mapper MyBabatis区域 写sql语句的地方
@Repository
public interface UserMapper extends BaseMapper<UserBean> {


    //接口：方法抽象，默认public                         #{}取值
    @Select("select * from tbl_user where username = #{username} and password = #{password} and status = #{status}")
    UserBean getUser(UserBean bean);
    //编译时会改形参名字
    @Select("select * from tbl_user where username = #{username}")
    UserBean haveUser(@Param("username")String username);

}
