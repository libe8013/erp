package com.zking.erp.stock.mapper;

import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.vo.StoredetailVo;

import java.util.List;
import java.util.Map;

public interface StoreDetailMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(StoreDetail record);

    int insertSelective(StoreDetail record);

    StoreDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(StoreDetail record);

    int updateByPrimaryKey(StoreDetail record);

    /**
     * 库存查询
     * @param storedetailVo
     * @return
     */
    List<Map<String,Object>> queryStoreLikePager(StoredetailVo storedetailVo);

    /**
     * 根据商品id 仓库id查询
     * @param storeDetail
     * @return
     */
    StoreDetail querySingleStoreDetail(StoreDetail storeDetail);

    List<StoreDetail> queryStoreDetail(StoreDetail storeDetail);
}