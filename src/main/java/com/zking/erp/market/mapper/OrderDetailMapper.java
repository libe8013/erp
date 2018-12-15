package com.zking.erp.market.mapper;

import com.zking.erp.market.model.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}