package com.example.shop.mapper;

import com.example.shop.bean.CommentBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CommentMapper {

//    @Select("select c.id,p.product,u.username,c.comment,c.ctime " +
//    "from tbl_comment c left join tbl_user u on u.id = c.uid left join tbl_product p on c.pid = p.id")
    @Select("select * from tbl_comment")
    List<CommentBean> list();

    @Insert("insert into tbl_comment(pid,uid,comment,ctime)values(#{pid},#{uid},#{comment},#{ctime})")
    void add(CommentBean commentBean);

    @Update("update tbl_comment set pid=#{pid},uid =#{uid},comment=#{comment},ctime=#{ctime} where id = #{id}")
    void update(CommentBean commentbean);
}
