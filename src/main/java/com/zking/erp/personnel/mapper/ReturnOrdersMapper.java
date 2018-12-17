package com.zking.erp.personnel.mapper;

import com.zking.erp.personnel.model.ReturnOrders;

public interface ReturnOrdersMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(ReturnOrders record);

    int insertSelective(ReturnOrders record);

    ReturnOrders selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ReturnOrders record);

    int updateByPrimaryKey(ReturnOrders record);
}