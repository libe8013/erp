package com.zking.erp.authority.mapper;

import com.zking.erp.authority.model.EmpRole;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRoleMapper {
    int deleteEmpOrRole(EmpRole empRole);

    int insert(EmpRole record);

    int insertSelective(EmpRole record);

    int updateEmpRole(EmpRole role);
}