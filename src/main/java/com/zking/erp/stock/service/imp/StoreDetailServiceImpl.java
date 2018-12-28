package com.zking.erp.stock.service.imp;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.stock.mapper.StoreDetailMapper;
import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.service.IStoreDetailService;
import com.zking.erp.stock.vo.StoredetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
public class StoreDetailServiceImpl implements IStoreDetailService {
    @Autowired
    private StoreDetailMapper storeDetailMapper;

    @Override
    public List<Map<String, Object>> queryStoreLikePager(StoredetailVo storedetailVo, PageBean pageBean) {
        return storeDetailMapper.queryStoreLikePager(storedetailVo);
    }

    @Override
    public int insert(StoreDetail record) {
        return storeDetailMapper.insert(record);
    }

    @Override
    public StoreDetail selectByPrimaryKey(String uuid) {
        return storeDetailMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public StoreDetail querySingleStoreDetail(StoreDetail storeDetail) {
        return storeDetailMapper.querySingleStoreDetail(storeDetail);
    }

    @Override
    public int updateByPrimaryKeySelective(StoreDetail record) {
        return storeDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<StoreDetail> queryStoreDetail(StoreDetail storeDetail) {
        return storeDetailMapper.queryStoreDetail(storeDetail);
    }


}
