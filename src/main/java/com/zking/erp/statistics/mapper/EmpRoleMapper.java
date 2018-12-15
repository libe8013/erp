package com.zking.erp.statistics.mapper;

import com.zking.erp.statistics.model.EmpRole;

public interface EmpRoleMapper {
    int insert(EmpRole record);

    int insertSelective(EmpRole record);
}