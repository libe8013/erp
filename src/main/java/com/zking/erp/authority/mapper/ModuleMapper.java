package com.zking.erp.authority.mapper;

public interface ModuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}