package com.zking.erp.stock.service.imp;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.stock.mapper.StoreDetailMapper;
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
}
