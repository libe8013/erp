package com.zking.erp.statistics.mapper;

import com.zking.erp.statistics.model.RoleModule;

public interface RoleModuleMapper {
    int insert(RoleModule record);

    int insertSelective(RoleModule record);
}