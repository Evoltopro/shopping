package com.example.shop.mapper;

import com.example.shop.bean.CartProduct;
import com.example.shop.bean.ProductBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartMapper {

    @Delete("delete from tbl_cart where pid = #{pid}")
    void delete(Integer pid);

    @Insert("insert into tbl_cart(count,pid,uid) values(1,#{id},#{uid})")
    void insert(Integer id, Integer uid);

    @Select("select*from vi_cart")
    List<CartProduct> select();

    @Select("select pid from tbl_cart where oid = #{uid}")
    Integer selectCartPid(Integer uid);

    @Select("select count from tbl_cart where oid = #{oid}")
    Integer selectCount(Integer oid);
}
