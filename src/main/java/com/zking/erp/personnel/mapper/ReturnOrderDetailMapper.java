package com.zking.erp.personnel.mapper;

import com.zking.erp.personnel.model.ReturnOrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReturnOrderDetailMapper {
    int deleteByPrimaryKey(String uuid);

    int delReturnOrderdetail(String ordersuuid);

    int insert(ReturnOrderDetail record);

    int insertSelective(ReturnOrderDetail record);

    ReturnOrderDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(ReturnOrderDetail record);

    int updateByPrimaryKey(ReturnOrderDetail record);

    int addReturnOrdersDetail(List<Map<String,Object>> maps);

    List<ReturnOrderDetail> queryReturnOrderDetail(ReturnOrderDetail returnOrderDetail);

}