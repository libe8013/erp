package com.zking.erp.personnel.contoller;

import com.zking.erp.authority.model.Role;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private IEmpService empService;

    @RequestMapping("/queryEmpStoreRole")
    @ResponseBody
    public List<Map<String,Object>> queryEmpStoreRole(Role role){
        Map<String,Object> map = new HashMap<>();

        List<Map<String,Object>> maps = empService.queryEmpStoreRole(role);

        return maps;
    }

    @RequestMapping("/querySingleEmp")
    @ResponseBody
    public Emp querySingleEmp(Emp emp){
        Emp emp1 = empService.selectByPrimaryKey(emp.getUuid());

        return emp1;
    }

}
