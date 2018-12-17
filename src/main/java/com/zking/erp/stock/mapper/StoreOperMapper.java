package com.zking.erp.stock.mapper;

import com.zking.erp.stock.model.StoreOper;

public interface StoreOperMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(StoreOper record);

    int insertSelective(StoreOper record);

    StoreOper selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(StoreOper record);

    int updateByPrimaryKey(StoreOper record);
}