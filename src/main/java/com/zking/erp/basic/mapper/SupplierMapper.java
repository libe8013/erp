package com.zking.erp.basic.mapper;

import com.zking.erp.basic.model.Supplier;

public interface SupplierMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}