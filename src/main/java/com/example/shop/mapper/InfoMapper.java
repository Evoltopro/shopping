package com.example.shop.mapper;

import com.example.shop.bean.InfoBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface InfoMapper  {
    @Select("select * from tbl_info")
    List<InfoBean> list();

    @Delete("delete from tbl_info where id=#{id}")
    void delete(int id);

    @Insert("insert into tbl_info(info,description,ctime,uid) values(#{info},#{description},#{ctime},#{uid})")
    void insertA(String info, String description, Date ctime,int uid);
}
