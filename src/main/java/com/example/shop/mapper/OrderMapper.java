package com.example.shop.mapper;

import com.example.shop.bean.OrderBean;
import com.example.shop.bean.ProductBean;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

public interface OrderMapper extends BaseMapper<OrderBean> {

    @Select("select * from order where uid = #{uid} order by ctime desc")
    List<OrderBean> selectOrderUser(@Param("uid")int uid);

    @Select("select * from order order by id desc")
    List<OrderBean> selectOrder();

}
