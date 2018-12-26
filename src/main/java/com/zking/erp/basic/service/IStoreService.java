package com.zking.erp.basic.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.basic.vo.StoreVo;
import com.zking.erp.stock.model.StoreDetail;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IStoreService {
    int deleteByPrimaryKey(String uuid);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    List<Store> queryStoreLikePager(Store store, PageBean pageBean);

    Map<String,Object> queryGoodsStore(StoreVo storeVo);

    List<Map<String,Object>> queryStoreGoodsSupplier(StoreVo storeVo);
}