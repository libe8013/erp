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
import java.util.UUID;

@Controller
@RequestMapping("/authorityrole")
public class RoleController {

    @Autowired
    private IRoleService roleService;



    /**
     * 查询所有角色
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


    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping("/addRole")
    @ResponseBody
    public Map<String,Object> addRole(Role role){

        String message = "添加成功";

        role.setId(UUID.randomUUID().toString().replace("-",""));

        Map<String,Object> map = new HashMap<String, Object>();


        try {
            roleService.insert(role);
        } catch (Exception e) {
            message="添加失败";
        }

        map.put("message",message);

        return map;
    }

    @RequestMapping("/editRole")
    @ResponseBody
    public Map<String,Object> editRole(Role role){

        String message = "修改角色成功";

        Map<String,Object> map = new HashMap<String, Object>();

        try {
            roleService.updateByPrimaryKey(role);
        } catch (Exception e) {
            message="修改角色失败";
        }
        map.put("message",message);

        return map;
    }


    @RequestMapping("/delrole")
    @ResponseBody
    public Map<String,Object> delrole(String id){
        System.out.println(id);

        String message = "删除成功";

        Map<String,Object> map = new HashMap<String, Object>();

        try {
            roleService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            message="删除失败";
        }

        map.put("message",message);

        return map;
    }













}




