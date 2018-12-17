package com.zking.erp.personnel.mapper;

import com.zking.erp.personnel.model.ReturnOrderDetail;

public interface ReturnOrderDetailMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(ReturnOrderDetail record);

    int insertSelective(ReturnOrderDetail record);

    ReturnOrderDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ReturnOrderDetail record);

    int updateByPrimaryKey(ReturnOrderDetail record);
}