package com.zking.erp.market.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.market.model.Orders;
import com.zking.erp.market.vo.OrderVo;

import java.util.List;
import java.util.Map;

public interface IOrdersService {
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
    List<Orders> queryOrdersPager(OrderVo orders, PageBean pageBean);

    /**
     * 查询采购订单
     * @param orders
     * @return
     */
    List<Orders> queryOrderPurchasePager(Orders orders,PageBean pageBean);
}
