package com.zking.erp.basic.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Store;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IStoreService {
    int deleteByPrimaryKey(String uuid);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    List<Store> queryStoreLikePager(Store store, PageBean pageBean);
}