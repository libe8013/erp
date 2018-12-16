package com.zking.erp.personnel.service.imp;

import com.zking.erp.authority.mapper.EmpRoleMapper;
import com.zking.erp.authority.mapper.RoleMapper;
import com.zking.erp.authority.model.EmpRole;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.service.IEmpService;
import com.zking.erp.personnel.mapper.EmpMapper;
import com.zking.erp.personnel.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpRoleMapper empRoleMapper;


    @Override
    public int deleteByPrimaryKey(EmpVo empVo) {
        EmpRole empRole = new EmpRole();
        empRole.setUserid(empVo.getUuid());
        empRoleMapper.deleteEmpOrRole(empRole);
        return empMapper.deleteByPrimaryKey(empVo.getUuid());
    }

    @Override
    public int updateByPrimaryKey(EmpVo empVo) {
        empMapper.updateByPrimaryKey(empVo);
        EmpRole empRole = new EmpRole();
        empRole.setUserid(empVo.getUuid());
        empRole.setRoleid(empVo.getRole().getId());
        return empRoleMapper.updateEmpRole(empRole);
    }

    @Override
    public int updateByPrimaryKeySelective(EmpVo empVo) {
        empMapper.updateByPrimaryKey(empVo);
        EmpRole empRole = new EmpRole();
        empRole.setUserid(empVo.getUuid());
        empRole.setRoleid(empVo.getRole().getId());
        return empRoleMapper.updateEmpRole(empRole);
    }

    @Override
    public List<Map<String, Object>> queryEmpPage(EmpVo empVo) {
        return empMapper.queryEmpPage(empVo);
    }


    @Override
    public int insert(EmpVo empVo) {
        empMapper.insert(empVo);
        EmpRole empRole = new EmpRole();
        empRole.setUserid(empVo.getUuid());
        empRole.setRoleid(empVo.getRole().getId());
        return empRoleMapper.insert(empRole);
    }
}
