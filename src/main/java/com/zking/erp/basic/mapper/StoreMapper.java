package com.zking.erp.basic.mapper;

import com.zking.erp.basic.model.Store;

public interface StoreMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);
}