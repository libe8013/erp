package com.zking.erp.personnel.mapper;

import com.zking.erp.personnel.model.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}