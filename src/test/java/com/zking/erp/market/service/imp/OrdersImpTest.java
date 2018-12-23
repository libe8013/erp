package com.zking.erp.market.service.imp;

import com.zking.erp.base.util.BaseTestCase;
import com.zking.erp.market.service.IOrdersService;
import com.zking.erp.market.vo.OrdersVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdersImpTest extends BaseTestCase{
    @Autowired
    private IOrdersService ordersService;
    private OrdersVo orderVo;

    @Test
    public void queryOrdersPage() {
//        orderVo = new OrderVo();
//        Emp emp = new Emp();
//        orderVo.setEmp(emp);
//        PageBean pageBean=new PageBean();
//        List<Map<String,Object>> list =ordersService.queryOrdersPager(orderVo,pageBean);
//        for (Map<String,Object> orders1 : list) {
//            System.out.println(orders1);
//        }
    }
}