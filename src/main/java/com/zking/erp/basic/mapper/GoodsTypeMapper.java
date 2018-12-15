package com.zking.erp.basic.mapper;

import com.zking.erp.basic.model.GoodsType;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
}