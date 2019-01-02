package com.zking.erp.authority.mapper;

import com.zking.erp.authority.Vo.RoleModuleVo;
import com.zking.erp.authority.model.Module;
import com.zking.erp.authority.model.RoleModule;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ModuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    /**
     * 查询所有模块
     * @param module
     * @return
     */
    List<Module> queryModuleLike(Module module);

    /**
     * 绑ZTree查询所有模块
     * @param module
     * @return
     */
    List<Map<String,Object>> queryModuleAll(Module module);


    List<Module> queryModuleUrl(String pid);
}