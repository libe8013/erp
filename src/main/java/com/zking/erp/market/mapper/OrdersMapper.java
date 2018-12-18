package com.zking.erp.market.mapper;

import com.zking.erp.market.model.Orders;
import com.zking.erp.market.vo.OrderVo;

import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    /**
     * 分页查询所有订单信息
     * @param orders
     * @return
     */
    List<Orders> queryOrdersPage(OrderVo orders);
}