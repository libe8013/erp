package com.zking.erp.market.mapper;

import com.zking.erp.market.model.Orders;
import com.zking.erp.market.vo.OrdersVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
    List<Orders> queryOrdersPage(OrdersVo orders);

    /**
     * 查询采购订单
     * @param orders
     * @return
     */
    List<Orders> queryOrderPurchase(Orders orders);

    /**
     * 添加订单
     * @param ordersVo
     * @return
     */
    int addOrders(OrdersVo ordersVo);
}