package com.zking.erp.personnel.contoller;

import com.zking.erp.market.model.OrderDetail;
import com.zking.erp.personnel.model.ReturnOrderDetail;
import com.zking.erp.personnel.model.ReturnOrders;
import com.zking.erp.personnel.service.IReturnOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/returnorderdetail")
public class ReturnOrdersDetailController {

    @Autowired
    private IReturnOrderDetailService returnOrderDetailService;

    @RequestMapping("/queryReturnOrderDetail")
    @ResponseBody
    public List<ReturnOrderDetail> queryReturnOrderDetail(ReturnOrderDetail returnOrderDetail){
        List<ReturnOrderDetail> returnOrderDetails = returnOrderDetailService.queryOrderDetail(returnOrderDetail);

        return returnOrderDetails;
    }

}
