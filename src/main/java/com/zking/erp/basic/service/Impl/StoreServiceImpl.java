package com.zking.erp.basic.service.Impl;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.mapper.StoreMapper;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.basic.service.IStoreService;
import com.zking.erp.basic.vo.StoreVo;
import com.zking.erp.stock.model.StoreDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoreServiceImpl implements IStoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return storeMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(Store record) {
        return storeMapper.insert(record);
    }

    @Override
    public int insertSelective(Store record) {
        return storeMapper.insertSelective(record);
    }

    @Override
    public Store selectByPrimaryKey(String uuid) {
        return storeMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Store record) {
        return storeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Store record) {
        return storeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Store> queryStoreLikePager(Store store, PageBean pageBean) {
        return storeMapper.queryStoreLikePager(store);
    }

    @Override
    public Map<String, Object> queryGoodsStore(StoreVo storeVo) {
        return storeMapper.queryGoodsStore(storeVo);
    }

    @Override
    public List<Map<String, Object>> queryStoreGoodsSupplier(StoreVo storeVo) {
        return storeMapper.queryStoreGoodsSupplier(storeVo);
    }
}
