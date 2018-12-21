package com.zking.erp.personnel.service.Impl;

import com.zking.erp.authority.model.Role;
import com.zking.erp.personnel.mapper.EmpMapper;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.service.IEmpService;
import com.zking.erp.personnel.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public int deleteByPrimaryKey(EmpVo empVo) {
        return 0;
    }

    @Override
    public int insert(EmpVo empVo) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(EmpVo empVo) {
        return 0;
    }

    @Override
    public Emp selectByPrimaryKey(String uuid) {
        return empMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(EmpVo empVo) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> queryEmpPage(EmpVo empVo) {
        return null;
    }

    @Override
    public List<Map<String,Object>> queryEmpStoreRole(Role role) {
        return empMapper.queryEmpStoreRole(role);
    }
}
