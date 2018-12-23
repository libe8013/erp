package com.zking.erp.stock.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.vo.StoredetailVo;

import java.util.List;
import java.util.Map;

public interface IStoreDetailService {

    /**
     * 库存查询
     * @param storedetailVo
     * @return
     */
    List<Map<String,Object>> queryStoreLikePager(StoredetailVo storedetailVo, PageBean pageBean);
}