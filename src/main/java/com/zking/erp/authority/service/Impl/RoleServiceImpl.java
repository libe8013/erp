package com.zking.erp.authority.service.Impl;

import com.zking.erp.authority.mapper.RoleMapper;
import com.zking.erp.authority.model.Role;
import com.zking.erp.authority.service.IRoleService;
import com.zking.erp.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Role record) {
        return roleMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Role record) {
        return roleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> queryRoleLike(Role role, PageBean pageBean) {
        return roleMapper.queryRoleLike(role);
    }
}
