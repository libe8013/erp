package com.zking.erp.market.service.imp;

import com.zking.erp.base.util.BaseTestCase;
import com.zking.erp.market.model.OrderDetail;
import com.zking.erp.market.service.IOrderDetailService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class OrderDetailImpTest extends BaseTestCase {
    @Autowired
    private IOrderDetailService orderDetailService;

    private OrderDetail orderDetail;




    @Test
    public void orderDetailquery() {
        orderDetail=new OrderDetail();
        List<OrderDetail> list=orderDetailService.OrderDetailquery(orderDetail);
        for (OrderDetail detail : list) {
            System.out.println(detail);
        }


     }
}