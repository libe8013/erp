package com.zking.erp.stock.service.imp;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.stock.mapper.StoreOperMapper;
import com.zking.erp.stock.model.StoreOper;
import com.zking.erp.stock.service.IStoreOperService;
import com.zking.erp.stock.vo.StoreOperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IStoreOperServiceImpl implements IStoreOperService {

    @Autowired
    private StoreOperMapper storeOperMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return storeOperMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(StoreOper record) {
        return storeOperMapper.insert(record);
    }

    @Override
    public int insertSelective(StoreOper record) {
        return storeOperMapper.insertSelective(record);
    }

    @Override
    public StoreOper selectByPrimaryKey(String uuid) {
        return storeOperMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(StoreOper record) {
        return storeOperMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StoreOper record) {
        return storeOperMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> queryRecordsPager(StoreOperVo storeOperVo, PageBean pageBean) {
        return storeOperMapper.queryRecordsPager(storeOperVo);
    }
}
