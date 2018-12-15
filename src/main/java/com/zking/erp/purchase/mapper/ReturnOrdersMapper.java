package com.zking.erp.purchase.mapper;

import com.zking.erp.purchase.model.ReturnOrders;

public interface ReturnOrdersMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(ReturnOrders record);

    int insertSelective(ReturnOrders record);

    ReturnOrders selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ReturnOrders record);

    int updateByPrimaryKey(ReturnOrders record);
}