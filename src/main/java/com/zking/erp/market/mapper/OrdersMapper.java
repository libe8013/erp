package com.zking.erp.market.mapper;

import com.zking.erp.basic.model.Goods;
import com.zking.erp.market.model.OrderDetail;
import com.zking.erp.market.model.Orders;
import com.zking.erp.market.vo.OrdersVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
     * @param goods
     * @return
     */
    int addOrders(OrdersVo goods);

    /**
     * 查询客户对应的商品订单
     * @param orders
     * @return
     */
    List<Map<String,Object>> queryClientGoods(Orders orders);

    /**
     * 查询供应商对应的商品订单
     * @param orders
     * @return
     */
    List<Map<String,Object>> querySupplierGoods(Orders orders);
}