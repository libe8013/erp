package com.zking.erp.market.service.imp;

import com.zking.erp.market.mapper.OrderDetailMapper;
import com.zking.erp.market.model.OrderDetail;
import com.zking.erp.market.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailImp implements IOrderDetailService{


    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return 0;
    }

    @Override
    public int insert(OrderDetail record) {
        return 0;
    }

    @Override
    public int insertSelective(OrderDetail record) {
        return 0;
    }

    @Override
    public OrderDetail selectByPrimaryKey(String uuid) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(OrderDetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(OrderDetail record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(OrderDetail record) {
        return 0;
    }

    @Override
    public List<OrderDetail> OrderDetailquery(OrderDetail orderDetail) {
        return orderDetailMapper.orderDetailquery(orderDetail);
    }
}
