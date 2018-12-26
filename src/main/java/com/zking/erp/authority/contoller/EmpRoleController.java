package com.zking.erp.authority.contoller;

import com.zking.erp.authority.Vo.EmpRoleVo;
import com.zking.erp.authority.model.Role;
import com.zking.erp.authority.service.IEmpRoleService;
import com.zking.erp.base.util.PageBean;
import com.zking.erp.personnel.model.Dept;
import com.zking.erp.personnel.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/authorityemp")
public class EmpRoleController {

    @Autowired
    private IEmpRoleService empRoleService;

    @RequestMapping("/queryEmpRole")
    @ResponseBody
    public Map<String,Object> queryEmpRole(EmpRoleVo empRoleVo, Emp emp, Dept dept, Role role, HttpServletRequest req){
        empRoleVo = new EmpRoleVo();
        emp = new Emp();
        dept = new Dept();
        role = new Role();
        empRoleVo.setDept(dept);
        empRoleVo.setEmp(emp);
        empRoleVo.setRole(role);
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        List<Map<String, Object>> list = empRoleService.queryEmpRolePager(empRoleVo,pageBean);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("meg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;
    }

}
