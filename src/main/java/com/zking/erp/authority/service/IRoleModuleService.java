package com.zking.erp.authority.service;

import com.zking.erp.authority.Vo.RoleModuleVo;
import com.zking.erp.authority.model.RoleModule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface IRoleModuleService {
    int insert(RoleModuleVo roleModuleVo);

    int DelRoleModule(String roleid);

    int insertSelective(RoleModule record);

    /**
     * 查询角色对应的所有模块
     * @param roleModule
     * @return
     */
    List<Map<String,Object>> queryRoleModule(RoleModule roleModule);

    void saveRoleModule(RoleModuleVo roleModuleVo);
}