package com.zking.erp.personnel.service;

import com.zking.erp.authority.model.Role;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.vo.EmpVo;

import java.util.List;
import java.util.Map;

public interface IEmpService {
    int deleteByPrimaryKey(EmpVo empVo);

    int insert(EmpVo empVo);

    int updateByPrimaryKey(EmpVo empVo);

    Emp selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(EmpVo empVo);

    List<Map<String,Object>> queryEmpPage(EmpVo empVo);

    List<Map<String,Object>> queryEmpStoreRole(Role role);

    /**
     * 修改密码
     * @param emp
     * @return
     */
    int updatePwd(Emp emp);

    List<Map<String,Object>> Login(Emp emp);
}