package com.zking.erp.authority.mapper;

import com.zking.erp.authority.model.RoleModule;

public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);
}