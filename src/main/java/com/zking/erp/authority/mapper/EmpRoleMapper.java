package com.zking.erp.authority.mapper;

import com.zking.erp.authority.model.EmpRole;

public interface EmpRoleMapper {
    int insert(EmpRole record);

    int insertSelective(EmpRole record);
}