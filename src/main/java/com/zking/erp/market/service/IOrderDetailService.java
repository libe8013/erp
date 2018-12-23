package com.zking.erp.market.service;

import com.zking.erp.market.model.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IOrderDetailService {
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
    List<OrderDetail> OrderDetailquery(OrderDetail orderDetail);

    /**
     * 根据订单id查询对应的订单详情
     * @param orderDetail
     * @return
     */
    List<OrderDetail> queryOrderDetail(OrderDetail orderDetail);
}
