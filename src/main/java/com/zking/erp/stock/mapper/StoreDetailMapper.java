package com.zking.erp.stock.mapper;

import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.vo.StoredetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface StoreDetailMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(StoreDetail record);

    int insertSelective(StoreDetail record);

    StoreDetail selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(StoreDetail record);

    int updateByPrimaryKey(StoreDetail record);

    List<Map<String,Object>> queryStoreLikePage(StoredetailVo storedetailVo);

}