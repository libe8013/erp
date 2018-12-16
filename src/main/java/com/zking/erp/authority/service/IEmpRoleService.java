package com.zking.erp.authority.service;

import com.zking.erp.authority.model.EmpRole;
import org.springframework.stereotype.Repository;

public interface IEmpRoleService {
    int deleteEmpOrRole(EmpRole empRole);

    int insert(EmpRole record);

    int insertSelective(EmpRole record);

    int updateEmpRole(EmpRole role);
}