package com.zking.erp.market.service.imp;


import com.zking.erp.base.util.PageBean;
import com.zking.erp.market.mapper.OrdersMapper;
import com.zking.erp.market.model.Orders;
import com.zking.erp.market.service.IOrdersService;
import com.zking.erp.market.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrdersImp implements IOrdersService{

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(Orders record) {
        return 0;
    }

    @Override
    public int insertSelective(Orders record) {
        return 0;
    }

    @Override
    public Orders selectByPrimaryKey(String uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Orders record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Orders record) {
        return 0;
    }

    @Override
    public List<Orders> queryOrdersPager(OrderVo orders, PageBean pageBean) {
        System.out.println(1111);
        return ordersMapper.queryOrdersPage(orders);
    }


}
