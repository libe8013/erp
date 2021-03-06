package com.zking.erp.authority.service.Impl;

import com.zking.erp.authority.mapper.ModuleMapper;
import com.zking.erp.authority.model.Module;
import com.zking.erp.authority.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ModuleServiceImpl implements IModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(Module record) {
        return 0;
    }

    @Override
    public int insertSelective(Module record) {
        return 0;
    }

    @Override
    public Module selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Module record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Module record) {
        return 0;
    }

    @Override
    public List<Module> queryModuleLike(Module module) {
        return moduleMapper.queryModuleLike(module);
    }

    @Override
    public List<Map<String, Object>> queryModuleAll(Module module) {
        return moduleMapper.queryModuleAll(module);
    }

    @Override
    public List<Module> queryModuleUrl(String pid) {
        return moduleMapper.queryModuleUrl(pid);
    }


}
