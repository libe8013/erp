package com.zking.erp.personnel.mapper;

import com.zking.erp.personnel.model.Dep;

public interface DepMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Dep record);

    int insertSelective(Dep record);

    Dep selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Dep record);

    int updateByPrimaryKey(Dep record);
}