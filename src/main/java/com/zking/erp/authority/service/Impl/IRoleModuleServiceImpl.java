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
    public int insert(RoleModuleVo roleModuleVo) {
        return roleModuleMapper.insert(roleModuleVo);
    }

    @Override
    public int DelRoleModule(String roleid) {
        return roleModuleMapper.DelRoleModule(roleid);
    }

    @Override
    public int insertSelective(RoleModule record) {
        return roleModuleMapper.insertSelective(record);
    }

    @Override
    public List<Map<String, Object>> queryRoleModule(RoleModule roleModule) {
        return roleModuleMapper.queryRoleModule(roleModule);
    }

    @Override
    public void saveRoleModule(RoleModuleVo roleModuleVo) {
        roleModuleMapper.DelRoleModule(roleModuleVo.getRoleid());
        roleModuleMapper.insert(roleModuleVo);
    }


}
