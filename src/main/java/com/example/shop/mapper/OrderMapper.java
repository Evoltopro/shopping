package com.example.shop.mapper;

import com.example.shop.bean.OrderBean;
import com.example.shop.bean.ProductBean;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<OrderBean> {

    @Select("select * from tbl_order where uid = #{uid} order by ctime desc")
    List<OrderBean> selectList(@Param("uid")int uid);

    @Select("select * from tbl_order order by id desc")
    List<OrderBean> selectOrder();


    @Delete("delete from tbl_order where id = #{id}")
    void delete(int id);
}
