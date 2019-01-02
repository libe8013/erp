package com.zking.erp.authority.service;

import com.zking.erp.authority.model.Module;

import java.util.List;
import java.util.Map;

public interface IModuleService {
    int deleteByPrimaryKey(String id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> queryModuleLike(Module module);

    /**
     * 绑ZTree查询所有模块
     * @param module
     * @return
     */
    List<Map<String,Object>> queryModuleAll(Module module);

    List<Module> queryModuleUrl(String pid);
}