package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.ProductBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ProductMapper extends BaseMapper<ProductBean> {

    @Select("select * from v_product where uid = #{uid} order by ctime desc")
    List<ProductBean> selectList(@Param("uid")int uid);//只能看到自己卖的东西

    @Select("select * from v_product order by id desc")
    List<ProductBean> selectView();

    @Select("select * from v_product where hot='热卖'")
    List<ProductBean> selectHot();
    @Select("select * from v_product where cid = #{cid} order by id desc")
    List<ProductBean> selectProduct(@Param("cid")int cid);
}
