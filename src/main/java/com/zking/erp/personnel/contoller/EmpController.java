package com.zking.erp.personnel.contoller;

import com.zking.erp.authority.model.Role;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping("/updPwd")
    @ResponseBody
    public Map<String,Object> updPwd(String uuid,String pwd){
        Emp emp = new Emp();
        emp.setUuid(uuid);
        emp.setPwd(pwd);

        String message = "修改密码成功";

        Map<String,Object> map = new HashMap<String, Object>();

        try {
            empService.updatePwd(emp);
        } catch (Exception e) {
            message="修改失败";
        }

        map.put("message",message);
        return map;
    }

    @RequestMapping("/Login")
    @ResponseBody
    public Map<String,Object> Login(String username, String pwd, HttpServletRequest req){
        HttpSession session = req.getSession();
        Emp emp = new Emp();
        emp.setUsername(username);
        emp.setPwd(pwd);

        List<Map<String, Object>> list = empService.Login(emp);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",true);

        if (list==null || list.size()==0) {
            map.put("message", "账号或密码错误");
            map.put("success",false);
        }else {
            session.setAttribute("emp",emp);
        }
        return map;
    }

}
