package com.zking.erp.basic.service;

import com.zking.erp.basic.model.GoodsType;

import java.util.List;

public interface IGoodsTypeService {
    int deleteByPrimaryKey(String uuid);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);

    List<GoodsType> queryGoodsType(GoodsType goodsType);
}