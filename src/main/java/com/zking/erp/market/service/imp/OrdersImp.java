package com.zking.erp.market.service.imp;


import com.zking.erp.base.util.PageBean;
import com.zking.erp.market.mapper.OrderDetailMapper;
import com.zking.erp.market.mapper.OrdersMapper;
import com.zking.erp.market.model.OrderDetail;
import com.zking.erp.market.model.Orders;
import com.zking.erp.market.service.IOrdersService;
import com.zking.erp.market.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrdersImp implements IOrdersService{

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return ordersMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(Orders record) {
        return ordersMapper.insert(record);
    }

    @Override
    public int insertSelective(Orders record) {
        return ordersMapper.insertSelective(record);
    }

    @Override
    public Orders selectByPrimaryKey(String uuid) {
        return ordersMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Orders record) {
        return ordersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return ordersMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Orders> queryOrdersPager(OrdersVo orders, PageBean pageBean) {
        return ordersMapper.queryOrdersPage(orders);
    }

    /**
     * 查询采购订单并分页
     * @param orders
     * @param pageBean
     * @return
     */
    @Override
    public List<Orders> queryOrderPurchasePager(Orders orders, PageBean pageBean) {
        return ordersMapper.queryOrderPurchase(orders);
    }

    @Override
    public int addOrders(OrdersVo ordersVo, List<Map<String,Object>> maps) {
        ordersMapper.addOrders(ordersVo);
        return orderDetailMapper.addOrdersDetail(maps);
    }


}
