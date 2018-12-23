package com.zking.erp.stock.mapper;

import com.zking.erp.stock.model.StoreOper;
import com.zking.erp.stock.vo.StoreOperVo;
import com.zking.erp.stock.vo.StoredetailVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StoreOperMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(StoreOper record);

    int insertSelective(StoreOper record);

    StoreOper selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(StoreOper record);

    int updateByPrimaryKey(StoreOper record);

    /**
     * 查询库存变动记录
     * @return
     */
    List<Map<String,Object>> queryRecordsPager(StoreOperVo storeOperVo);
}