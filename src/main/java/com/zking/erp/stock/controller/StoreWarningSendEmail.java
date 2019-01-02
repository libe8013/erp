package com.zking.erp.stock.controller;

import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.service.IEmpService;
import com.zking.erp.personnel.vo.EmpVo;
import com.zking.erp.stock.service.IStoreDetailService;
import com.zking.erp.stock.task.TestSpringEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/email")
public class StoreWarningSendEmail {

    @Autowired
    private IEmpService empService;

    @Autowired
    private IStoreDetailService storeDetailService;

    @RequestMapping("/sendEmail")
    @ResponseBody
    public Map<String,Object> sendEmail(EmpVo empVo){
        Map<String,Object> map = new HashMap<>();

        String email = "2233047175@qq.com";

        String message = "";

        message = TestSpringEmail.sendTextEmail(empVo, email, message);

        map.put("message",message);

        return map;
    }

    @RequestMapping("/test")
    @ResponseBody
    public Map<String,Object> test(){
        Map<String,Object> m = new HashMap<>();
        String message = "";
        List<Map<String, Object>> maps = storeDetailService.queryWarningPager(null);
        for (Map<String, Object> map : maps) {
            Emp emp1 = empService.selectByPrimaryKey(map.get("empuuid").toString());
            EmpVo empVo = new EmpVo();
            empVo.setTitle("库存预警");
            empVo.setContext("有商品库存小于待发货数量,请及时补货");
            String email = "2233047175@qq.com";
            String s = TestSpringEmail.sendTextEmail(empVo, email, message);
        }
        m.put("message",message);
        return m;
    }

}
