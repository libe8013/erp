package com.zking.erp.authority.contoller;

import com.zking.erp.authority.Vo.RoleModuleVo;
import com.zking.erp.authority.model.Module;
import com.zking.erp.authority.model.Role;
import com.zking.erp.authority.model.RoleModule;
import com.zking.erp.authority.service.IRoleModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/roleModule")
public class RoleModuleController {

    @Autowired
    private IRoleModuleService roleModuleService;


    /**
     * 查询角色对应的模块
     * @param roleModuleVo
     * @return
     */
    @RequestMapping("/queryRoleModule")
    @ResponseBody
    public Map<String,Object> queryRoleModule(RoleModuleVo roleModuleVo){
        Role role = new Role();
        Module module = new Module();
        roleModuleVo.setRole(role);
        roleModuleVo.setModule(module);

        List<Map<String, Object>> list = roleModuleService.queryRoleModule(roleModuleVo);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("meg","");
        map.put("data",list);
        return map;
    }

}
