package com.zking.erp.personnel.service;

import com.zking.erp.market.model.OrderDetail;
import com.zking.erp.personnel.model.ReturnOrderDetail;
import com.zking.erp.personnel.model.ReturnOrders;

import java.util.List;
import java.util.Map;

public interface IReturnOrderDetailService {
    int deleteByPrimaryKey(String uuid);

    int insert(ReturnOrderDetail record);

    int insertSelective(ReturnOrderDetail record);

    ReturnOrderDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ReturnOrderDetail record);

    int updateByPrimaryKey(ReturnOrderDetail record);

    int addReturnOrders(List<Map<String,Object>> maps);

    List<ReturnOrderDetail> queryOrderDetail(ReturnOrderDetail returnOrderDetail);
}