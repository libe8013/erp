package com.zking.erp.market.contoller;

import com.zking.erp.market.model.OrderDetail;
import com.zking.erp.market.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderDetailController {
    @Autowired
    private IOrderDetailService orderDetailService;

    @RequestMapping("/OrderDetailquery")
    public  String OrderDetailquery(OrderDetail orderDetail ){
        List<OrderDetail> list=orderDetailService.OrderDetailquery(orderDetail);
        for (OrderDetail detail : list) {
            System.out.println(detail);
        }

        return null;
    }


}
