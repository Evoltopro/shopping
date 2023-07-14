package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.CollectBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectMapper extends BaseMapper<CollectBean> {
    @Select("select * from view_collect  where uid=${uid} order by ctime desc")
    List<CollectMapper> selectList(@Param("uid")int uid); //方法重写

    @Select("select *from view_collect order by id desc")
    List<CollectBean> selectView();

    @Select("select * from view_collect where uid=#{uid}" )
    List<CollectBean> selectCollect(@Param("uid")int uid);

    //web接口
    @Select("select * from view_collect")
    List<CollectBean> select();

    @Insert("insert into tbl_collect(pid,uid) values(#{pid},#{uid})")
    void insertA(int pid,int uid);


}
