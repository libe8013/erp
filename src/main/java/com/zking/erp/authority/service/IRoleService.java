package com.zking.erp.authority.service;

import com.zking.erp.authority.model.Role;
import com.zking.erp.base.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IRoleService {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int updateByPrimaryKey(Role record);

    List<Map<String,Object>> queryRoleLike(Role role, PageBean pageBean);


}