package com.zking.erp.authority.service;

import com.zking.erp.authority.model.EmpRole;
import com.zking.erp.authority.model.Role;
import org.springframework.stereotype.Repository;

public interface IRoleService {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int updateByPrimaryKey(Role record);
    
}