package com.zking.erp.personnel.service.Impl;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.personnel.mapper.ReturnOrderDetailMapper;
import com.zking.erp.personnel.mapper.ReturnOrdersMapper;
import com.zking.erp.personnel.model.ReturnOrderDetail;
import com.zking.erp.personnel.model.ReturnOrders;
import com.zking.erp.personnel.service.IReturnOrdersService;
import com.zking.erp.personnel.vo.ReturnOrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReturnOrdersServiceImpl implements IReturnOrdersService {

    @Autowired
    private ReturnOrdersMapper returnOrdersMapper;

    @Autowired
    private ReturnOrderDetailMapper returnOrderDetailMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return returnOrdersMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(ReturnOrders record) {
        return returnOrdersMapper.insert(record);
    }

    @Override
    public int insertSelective(ReturnOrders record) {
        return returnOrdersMapper.insertSelective(record);
    }

    @Override
    public ReturnOrders selectByPrimaryKey(String uuid) {
        return returnOrdersMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(ReturnOrders record) {
        return returnOrdersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ReturnOrders record) {
        return returnOrdersMapper.updateByPrimaryKey(record);
    }

    @Override
    public int addReturnOrders(ReturnOrdersVo returnOrdersVo, List<Map<String,Object>> maps) {
        returnOrdersMapper.addReturnOrders(returnOrdersVo);
        return returnOrderDetailMapper.addReturnOrdersDetail(maps);
    }

    @Override
    public List<ReturnOrders> queryReturnOrdersPager(ReturnOrders returnOrders, PageBean pageBean) {
        return returnOrdersMapper.queryReturnOrdersPager(returnOrders);
    }
}
