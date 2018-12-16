package com.zking.erp.authority.mapper;

import com.zking.erp.authority.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int updateByPrimaryKey(Role record);


}