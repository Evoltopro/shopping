package com.example.shop.mapper;

import com.example.shop.bean.InfoBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InfoMapper {
    @Select("select * from tbl_info")
    List<InfoBean> list();

    @Delete("delete from tbl_info where id=#{id}")
    void delete(int id);
}
