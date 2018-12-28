package com.zking.erp.personnel.contoller;

import com.zking.erp.authority.model.Role;
import com.zking.erp.base.util.PageBean;
import com.zking.erp.personnel.model.Dept;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.service.IEmpService;
import com.zking.erp.personnel.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private IEmpService empService;
    private EmpVo empVo=new EmpVo();

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

        List<Emp> list = empService.Login(emp);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("success",true);

        if (list==null || list.size()==0) {
            map.put("message", "账号或密码错误");
            map.put("success",false);
        }else {
            session.setAttribute("emp",list.get(0));
        }
        return map;
    }
    @RequestMapping("/queryDeptList")
    @ResponseBody
    public Map<String, Object> queryDeptList(Dept dept) {

        List<Dept> list = empService.queryDeptList(dept);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", list);
        return map;
    }

    @RequestMapping("/queryEmpListPager")
    @ResponseBody
    public Map<String, Object> queryEmpListPager(HttpServletRequest req, EmpVo empVo) {
        PageBean pagebean = new PageBean();
        pagebean.setRequest(req);
        List<Map<String,Object>> list = empService.queryEmpListPager(empVo,pagebean);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pagebean.getTotal());
        map.put("data", list);
        return map;
    }

    @RequestMapping("/addEmp")
    @ResponseBody
    public Map<String, Object> addEmp(EmpVo empVo) {
        String message = "员工新增成功";
        empVo.setUuid(UUID.randomUUID().toString().replace("-", ""));
        Map<String, Object> map = new HashMap<>();
        try {
            empService.insert(empVo);
        } catch (Exception e) {
            message = "员工新增失败";
        }
        map.put("msg", message);
        return map;

    }

    @RequestMapping("/editEmp")
    @ResponseBody
    public  Map<String,Object> editEmp(Emp emp){
        String message = "保存成功";
        Map<String,Object> map  = new HashMap<>();
        try {
            empService.updateByPrimaryKeySelective(emp);
        } catch (Exception e) {
            message = "保存失败";
        }
        map.put("msg", message);
        return map;
    }


    @RequestMapping("/delEmp")
    @ResponseBody
    public Map<String,Object> delEmp(EmpVo empVo){
        String message = "删除成功";
        Map<String,Object> map  = new HashMap<>();
        try {
            empService.deleteByPrimaryKey(empVo.getUuid());
        } catch (Exception e) {
            message = "删除失败";
        }
        map.put("msg",message);
        return map;
    }
}
