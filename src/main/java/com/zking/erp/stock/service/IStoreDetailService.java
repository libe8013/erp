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

    int insert(StoreDetail record);

    StoreDetail selectByPrimaryKey(String uuid);

    /**
     * 根据商品id 仓库id查询
     * @param storeDetail
     * @return
     */
    StoreDetail querySingleStoreDetail(StoreDetail storeDetail);

    int updateByPrimaryKeySelective(StoreDetail record);

    /**
     * 查询所有仓库明细
     * @param storeDetail
     * @return
     */
    List<StoreDetail> queryStoreDetail(StoreDetail storeDetail);

    /**
     * 库存预警查询
     * @return
     */
    List<Map<String,Object>> queryWarningPager(PageBean pageBean);

    StoreDetail querySingleStore(StoreDetail storeDetail);
}