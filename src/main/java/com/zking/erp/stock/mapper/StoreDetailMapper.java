package com.zking.erp.stock.mapper;

import com.zking.erp.stock.model.StoreDetail;

public interface StoreDetailMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(StoreDetail record);

    int insertSelective(StoreDetail record);

    StoreDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(StoreDetail record);

    int updateByPrimaryKey(StoreDetail record);
}