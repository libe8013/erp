package com.zking.erp.stock.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.stock.model.StoreOper;
import com.zking.erp.stock.vo.StoreOperVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IStoreOperService {
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
    List<Map<String,Object>> queryRecordsPager(StoreOperVo storeOperVo, PageBean pageBean);
}