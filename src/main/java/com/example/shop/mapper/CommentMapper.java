package com.example.shop.mapper;

import com.example.shop.bean.CommentBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("select c.id,p.product,u.username,c.comment,c.ctime \n" +
            "from tbl_product p,tbl_user u, tbl_comment c\n" +
            "where c.pid = p.id and c.uid = u.id")
    List<CommentBean> list();

    @Insert("insert into tbl_comment(pid,uid,comment,ctime)values(#{pid},#{uid},#{comment},#{ctime})")
    void add(CommentBean commentBean);

    @Update("update tbl_comment set pid=#{pid},uid =#{uid},comment=#{comment},ctime=#{ctime} where id = #{id}")
    void update(CommentBean commentbean);
}
