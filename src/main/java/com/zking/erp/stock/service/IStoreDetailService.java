package com.zking.erp.stock.service;

import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.vo.StoredetailVo;

import java.util.List;
import java.util.Map;

public interface IStoreDetailService {

    List<Map<String,Object>> queryStoreLikePage(StoredetailVo storedetailVo);

}