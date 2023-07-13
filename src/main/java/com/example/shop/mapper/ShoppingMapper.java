package com.example.shop.mapper;

import com.example.shop.bean.ProductBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShoppingMapper {

    @Select("select * from tbl_cart where uid = #{uid} order by ctime desc")
    Integer selectList(@Param("uid")int uid);
}
