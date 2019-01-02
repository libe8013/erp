package com.zking.erp.personnel.service.Impl;

import com.zking.erp.personnel.mapper.ReturnOrderDetailMapper;
import com.zking.erp.personnel.model.ReturnOrderDetail;
import com.zking.erp.personnel.service.IReturnOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReturnOrderDetailServiceImpl implements IReturnOrderDetailService {

    @Autowired
    private ReturnOrderDetailMapper returnOrderDetailMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return returnOrderDetailMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(ReturnOrderDetail record) {
        return returnOrderDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(ReturnOrderDetail record) {
        return returnOrderDetailMapper.insertSelective(record);
    }

    @Override
    public ReturnOrderDetail selectByPrimaryKey(String uuid) {
        return returnOrderDetailMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(ReturnOrderDetail record) {
        return returnOrderDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReturnOrderDetail record) {
        return returnOrderDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public int addReturnOrders(List<Map<String, Object>> maps) {
        return returnOrderDetailMapper.addReturnOrdersDetail(maps);
    }

    @Override
    public List<ReturnOrderDetail> queryOrderDetail(ReturnOrderDetail returnOrderDetail) {
        return returnOrderDetailMapper.queryReturnOrderDetail(returnOrderDetail);
    }

    @Override
    public int delReturnOrderdetail(String ordersuuid) {
        return returnOrderDetailMapper.delReturnOrderdetail(ordersuuid);
    }

    @Override
    public List<Map<String,Object>> queryGoodsStore(ReturnOrderDetail returnOrderDetail) {
        return returnOrderDetailMapper.queryGoodsStore(returnOrderDetail);
    }
}
