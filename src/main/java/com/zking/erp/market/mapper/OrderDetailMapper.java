package com.zking.erp.market.mapper;

import com.zking.erp.market.model.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKeyWithBLOBs(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    /**
     * 查询订单详情
     * @param orderDetail
     * @return
     */
    List<OrderDetail> orderDetailquery(OrderDetail orderDetail);
}