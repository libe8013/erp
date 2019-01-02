package com.zking.erp.stock.task;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.service.IEmpService;
import com.zking.erp.personnel.vo.EmpVo;
import com.zking.erp.stock.service.IStoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class TestTask {

    @Autowired
    private IStoreDetailService storeDetailService;

    @Autowired
    private IEmpService empService;

    @Scheduled(cron = "0 0 0 * * ?")//每天早上10：42触发
    public void test(){
        List<Map<String, Object>> maps = storeDetailService.queryWarningPager(null);
        for (Map<String, Object> map : maps) {
            Emp emp1 = empService.selectByPrimaryKey(map.get("empuuid").toString());
            EmpVo empVo = new EmpVo();
            empVo.setTitle("库存预警");
            empVo.setContext("有商品库存小于待发货数量,请及时补货");
            String email = "2233047175@qq.com";
            String s = TestSpringEmail.sendTextEmail(empVo, email, "");
        }
    }
}
