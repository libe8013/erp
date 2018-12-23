package com.zking.erp.authority.mapper;

import com.zking.erp.authority.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 查询所有角色
     * @param role
     * @return
     */
    List<Map<String,Object>> queryRoleLike(Role role);


}