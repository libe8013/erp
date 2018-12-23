package com.zking.erp.market.mapper;

import com.zking.erp.market.model.OrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDetailMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKeyWithBLOBs(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    /**
     * 添加采购的订单明细
     * @param maps
     * @return
     */
    int addOrdersDetail(List<Map<String,Object>> maps);

    /**
     * 查询订单详情
     * @param orderDetail
     * @return
     */
    List<OrderDetail> orderDetailquery(OrderDetail orderDetail);

    List<OrderDetail> queryOrderDetail(OrderDetail orderDetail);
}