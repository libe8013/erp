package com.zking.erp.purchase.mapper;

import com.zking.erp.purchase.model.ReturnOrdersDetail;

public interface ReturnOrdersDetailMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(ReturnOrdersDetail record);

    int insertSelective(ReturnOrdersDetail record);

    ReturnOrdersDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ReturnOrdersDetail record);

    int updateByPrimaryKey(ReturnOrdersDetail record);
}