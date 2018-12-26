package com.zking.erp.personnel.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.personnel.model.ReturnOrders;
import com.zking.erp.personnel.vo.ReturnOrdersVo;

import java.util.List;
import java.util.Map;

public interface IReturnOrdersService {
    int deleteByPrimaryKey(String uuid);

    int insert(ReturnOrders record);

    int insertSelective(ReturnOrders record);

    ReturnOrders selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ReturnOrders record);

    int updateByPrimaryKey(ReturnOrders record);

    /**
     * 登记退货订单|添加退货订单
     * @param returnOrdersVo
     * @return
     */
    int addReturnOrders(ReturnOrdersVo returnOrdersVo, List<Map<String,Object>> maps);

    List<ReturnOrders> queryReturnOrdersPager(ReturnOrders returnOrders, PageBean pageBean);
}