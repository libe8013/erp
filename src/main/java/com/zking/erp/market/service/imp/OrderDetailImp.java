package com.zking.erp.market.service.imp;

import com.zking.erp.market.mapper.OrderDetailMapper;
import com.zking.erp.market.model.OrderDetail;
import com.zking.erp.market.service.IOrderDetailService;
import com.zking.erp.market.vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailImp implements IOrderDetailService{


    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return orderDetailMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(OrderDetail record) {
        return orderDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(OrderDetail record) {
        return orderDetailMapper.insertSelective(record);
    }

    @Override
    public OrderDetail selectByPrimaryKey(String uuid) {
        return orderDetailMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderDetail record) {
        return orderDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(OrderDetail record) {
        return orderDetailMapper.updateByPrimaryKeyWithBLOBs(record);
    }

    @Override
    public int updateByPrimaryKey(OrderDetail record) {
        return orderDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<OrderDetail> OrderDetailquery(OrderDetail orderDetail) {
        return orderDetailMapper.orderDetailquery(orderDetail);
    }

    @Override
    public List<OrderDetail> queryOrderDetail(OrderDetail orderDetail) {
        return orderDetailMapper.queryOrderDetail(orderDetail);
    }

    @Override
    public List<OrderDetail> queryGoodsOrderdetailMarket(OrderDetail orderDetail) {
        return orderDetailMapper.queryGoodsOrderdetailMarket(orderDetail);
    }

}
