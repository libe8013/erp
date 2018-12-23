package com.zking.erp.authority.contoller;

import com.zking.erp.authority.model.Role;
import com.zking.erp.authority.service.IRoleService;
import com.zking.erp.base.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/authorityrole")
public class RoleContoller {

    @Autowired
    private IRoleService roleService;

    /**
     * 查询所以角色
     * @param rolename
     * @param req
     * @return
     */
    @RequestMapping("/queryRole")
    @ResponseBody
    public Map<String,Object> queryRole(String rolename, HttpServletRequest req){
        Role role = new Role();
        role.setRolename(rolename);
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        List<Map<String, Object>> list = roleService.queryRoleLike(role, pageBean);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("meg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;
    }

}
