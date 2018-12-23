package com.zking.erp.authority.service;

import com.zking.erp.authority.Vo.EmpRoleVo;
import com.zking.erp.authority.model.EmpRole;
import com.zking.erp.base.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IEmpRoleService {
    int deleteEmpOrRole(EmpRole empRole);

    int insert(EmpRole record);

    int insertSelective(EmpRole record);

    int updateEmpRole(EmpRole role);

    /**
     * 查询用户对应的角色
     * @param empRoleVo
     * @return
     */
    List<Map<String,Object>> queryEmpRolePager(EmpRoleVo empRoleVo, PageBean pageBean);
}