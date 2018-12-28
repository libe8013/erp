package com.zking.erp.personnel.service.Impl;

import com.zking.erp.authority.model.Role;
import com.zking.erp.base.util.PageBean;
import com.zking.erp.personnel.mapper.EmpMapper;
import com.zking.erp.personnel.model.Dept;
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
    public List<Map<String, Object>> queryEmpListPager(EmpVo empVo, PageBean pageBean) {
        if (empVo.getEndtime() != null) {
            return empMapper.queryEmpListPager(empVo);
        }else{
            return empMapper.queryEmp2ListPager(empVo);

        }
    }
    @Override
    public List<Dept> queryDeptList(Dept dept) {
        return empMapper.queryDeptList(dept);
    }

    @Override
    public int insert(Emp record) {
        return empMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Emp record) {
        return empMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public int deleteByPrimaryKey(String uuid) {
        return empMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public Emp selectByPrimaryKey(String uuid) {
        return empMapper.selectByPrimaryKey(uuid);
    }


    @Override
    public List<Map<String, Object>> queryEmpPage(EmpVo empVo) {
        return null;
    }

    @Override
    public List<Map<String,Object>> queryEmpStoreRole(Role role) {
        return empMapper.queryEmpStoreRole(role);
    }

    @Override
    public int updatePwd(Emp emp) {
        return empMapper.updatePwd(emp);
    }

    @Override
    public List<Emp> Login(Emp emp) {
        return empMapper.Login(emp);
    }
}
