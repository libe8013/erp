package com.zking.erp.authority.contoller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.erp.authority.Vo.RoleModuleVo;
import com.zking.erp.authority.model.Module;
import com.zking.erp.authority.model.Role;
import com.zking.erp.authority.model.RoleModule;
import com.zking.erp.authority.service.IRoleModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
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
     * @param
     * @return
     */
    @RequestMapping("/queryRoleModule")
    @ResponseBody
    public Map<String,Object> queryRoleModule(String roleid){
       RoleModule roleModule = new RoleModule();
       roleModule.setRoleid(roleid);
        List<Map<String, Object>> list = roleModuleService.queryRoleModule(roleModule);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("meg","");
        map.put("data",list);
        return map;
    }


    @RequestMapping("/saveRoleMoudle")
    @ResponseBody
    public Map<String,Object> saveRoleMoudle(RoleModuleVo roleModuleVo,String arrJson) throws IOException {
        String message = "保存权限成功";
        ObjectMapper objectMapper = new ObjectMapper();
        String[] ids = objectMapper.readValue(arrJson, new TypeReference<String[]>() {
        });

        try {
            roleModuleVo.setIds(ids);
            roleModuleService.DelRoleModule(roleModuleVo.getRoleid());
            roleModuleService.insert(roleModuleVo);
        } catch (Exception e) {
            message="保存权限失败";
        }
        Map<String,Object> map = new HashMap<>();

        map.put("message",message);

        return map;
    }



}
