package com.example.shop.mapper;

import com.example.shop.bean.CommentBean;
import com.example.shop.bean.ProductBean;
import com.example.shop.bean.ShoppingBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShoppingMapper {

    @Select("select * from v_shopping")
    List<ShoppingBean> select();


    @Insert("insert into tbl_shopping(count,pid,oid) values(#{count},#{pid}),#{oid}")
    void insert(Integer count,Integer pid,Integer oid);
}
