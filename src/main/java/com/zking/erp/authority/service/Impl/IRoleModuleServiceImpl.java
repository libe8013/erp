package com.zking.erp.authority.service.Impl;

import com.zking.erp.authority.Vo.RoleModuleVo;
import com.zking.erp.authority.mapper.RoleModuleMapper;
import com.zking.erp.authority.model.RoleModule;
import com.zking.erp.authority.service.IRoleModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IRoleModuleServiceImpl implements IRoleModuleService {

    @Autowired
    private RoleModuleMapper roleModuleMapper;

    @Override
    public int insert(RoleModule record) {
        return roleModuleMapper.insert(record);
    }

    @Override
    public int insertSelective(RoleModule record) {
        return roleModuleMapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> queryRoleModule(RoleModuleVo roleModuleVo) {
        return roleModuleMapper.queryRoleModule(roleModuleVo);
    }


}
