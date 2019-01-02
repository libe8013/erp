package com.zking.erp.personnel.contoller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.personnel.model.Dept;
import com.zking.erp.personnel.service.IDeptService;

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
@RequestMapping("/dept")
public class DeptContoller {

    @Autowired
    private IDeptService deptService;

    @RequestMapping("/queryDeptList")
    @ResponseBody
    public Map<String, Object> queryDeptListPager(Dept dept, HttpServletRequest req) {
        PageBean pagebean = new PageBean();
        pagebean.setRequest(req);
        List<Dept> list = deptService.queryDeptListPager(dept, pagebean);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pagebean.getTotal());
        map.put("data", list);
        return map;
    }


    @RequestMapping("/addDept")
    @ResponseBody
    public Map<String, Object> addDept(Dept dept) {
        String message = "部门新增成功";
        dept.setUuid(UUID.randomUUID().toString().replace("-", ""));
        Map<String, Object> map = new HashMap<>();
        try {
            deptService.insert(dept);
        } catch (Exception e) {
            message = "部门新增失败";
        }
        map.put("msg", message);
        return map;

    }

    @RequestMapping("/editDept")
    @ResponseBody
    public  Map<String,Object> editDept(Dept dept){
        String message = "保存成功";
        Map<String,Object> map  = new HashMap<>();
        try {
            deptService.updateByPrimaryKeySelective(dept);
        } catch (Exception e) {
            message = "保存失败";
        }
        map.put("msg", message);
        return map;
    }


    @RequestMapping("/delDept")
    @ResponseBody
    public Map<String,Object> delDept(Dept dept){
        String message = "删除成功";
        Map<String,Object> map  = new HashMap<>();
        try {
            deptService.deleteByPrimaryKey(dept.getUuid());
        } catch (Exception e) {
            message = "删除失败";
        }
        map.put("msg",message);
        return map;
    }
}