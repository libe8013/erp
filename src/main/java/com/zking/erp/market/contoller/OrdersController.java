package com.zking.erp.market.contoller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.market.model.Orders;
import com.zking.erp.market.service.IOrdersService;
import com.zking.erp.market.vo.OrderVo;
import com.zking.erp.personnel.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;


    @RequestMapping("/queryOrdersPage")
    @ResponseBody
    public Map<String, Object> queryOrdersPage(HttpServletRequest req,Emp emp) {

        OrderVo orderVo = new OrderVo();
        emp = new Emp();
        orderVo.setEmp(emp);
        PageBean pageBean = new PageBean();

        List<Orders> list = ordersService.queryOrdersPager(orderVo, pageBean);
        pageBean.setRequest(req);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;

    }

    /**
     * 查询采购订单
     * @param orders
     * @param req
     * @return
     */
    @RequestMapping("/queryPurchasePager")
    @ResponseBody
    public Map<String,Object> queryPurchasePager(Orders orders,HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();

        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);

        List<Orders> orders1 = ordersService.queryOrderPurchasePager(orders, pageBean);

        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",orders1);

        return map;
    }
}