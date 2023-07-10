package com.example.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shop.bean.ProductBean;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface ProductMapper extends BaseMapper<ProductBean> {

    @Select("select * from v_product order by ctime desc")
    List<ProductBean> selectList();
}
