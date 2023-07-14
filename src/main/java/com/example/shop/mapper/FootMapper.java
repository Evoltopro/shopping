package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.CollectBean;
import com.example.shop.bean.FootBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface FootMapper extends BaseMapper<FootBean> {
    @Select("select * from view_foot  where uid=${uid} order by ctime desc")
    List<FootMapper> selectList(@Param("uid")int uid); //方法重写

    @Select("select *from view_foot order by id desc")
    List<FootBean> selectView();

    @Select("select * from v_foot")
    List<FootBean> selectFoot();

    //web接口
    //@Select("select * from view_foot")
    //List<FootBean> select();

    @Insert("insert into tbl_foot(uid,pid) values(#{uid},#{pid})")
    void insert(int uid,int pid);

    @Insert("insert into tbl_foot(uid,pid,time)values(#{uid},#{pid},#{ctime})")
    void insertA(Integer uid, Integer pid, Date ctime);
}
