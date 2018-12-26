package com.zking.erp.personnel.mapper;

import com.zking.erp.personnel.model.ReturnOrders;
import com.zking.erp.personnel.vo.ReturnOrdersVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnOrdersMapper {
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
    int addReturnOrders(ReturnOrdersVo returnOrdersVo);

    List<ReturnOrders> queryReturnOrdersPager(ReturnOrders returnOrders);
}