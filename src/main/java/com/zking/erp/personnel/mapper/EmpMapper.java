package com.zking.erp.personnel.mapper;

import com.zking.erp.personnel.model.Emp;

public interface EmpMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}