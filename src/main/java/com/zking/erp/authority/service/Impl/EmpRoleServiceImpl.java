package com.zking.erp.authority.service.Impl;

import com.zking.erp.authority.Vo.EmpRoleVo;
import com.zking.erp.authority.mapper.EmpRoleMapper;
import com.zking.erp.authority.model.EmpRole;
import com.zking.erp.authority.service.IEmpRoleService;
import com.zking.erp.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpRoleServiceImpl implements IEmpRoleService {

    @Autowired
    private EmpRoleMapper empRoleMapper;

    @Override
    public int deleteEmpOrRole(EmpRole empRole) {
        return empRoleMapper.deleteEmpOrRole(empRole);
    }

    @Override
    public int insert(EmpRole record) {
        return empRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(EmpRole record) {
        return empRoleMapper.insertSelective(record);
    }

    @Override
    public int updateEmpRole(EmpRole role) {
        return empRoleMapper.updateEmpRole(role);
    }

    @Override
    public List<Map<String, Object>> queryEmpRolePager(EmpRoleVo empRoleVo, PageBean pageBean) {
        return empRoleMapper.queryEmpRolePager(empRoleVo);
    }
}
