package com.example.shop.mapper;

import com.example.shop.bean.CartProduct;
import com.example.shop.bean.ProductBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {

    @Insert("insert into tbl_cart(count,pid,uid) values(1,#{id},#{uid})")
    void insert(Integer id, Integer uid);

    @Select("select*from vv_cart")
    List<CartProduct> select();
}
