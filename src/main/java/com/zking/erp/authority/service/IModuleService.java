package com.zking.erp.authority.service;

import com.zking.erp.authority.model.Module;

import java.util.List;

public interface IModuleService {
    int deleteByPrimaryKey(String id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> queryModuleLike(Module module);
}