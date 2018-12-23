package com.zking.erp.market.contoller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.market.model.Orders;
import com.zking.erp.market.service.IOrdersService;
import com.zking.erp.market.vo.OrdersVo;
import com.zking.erp.personnel.model.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/queryOrdersPage")
    @ResponseBody
    public Map<String, Object> queryOrdersPage(HttpServletRequest req,Emp emp) {

        OrdersVo orderVo = new OrdersVo();
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

    @RequestMapping("/addOrders")
    @ResponseBody
    public Map<String,Object> addOrders(OrdersVo ordersVo,HttpServletRequest req,String goodsJson) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        HttpSession session = req.getSession();

        ObjectMapper mapper = new ObjectMapper();

        List<Map<String,Object>> goodsLst = mapper.readValue(goodsJson, new TypeReference<List<Map<String,Object>>>() {});

        List<Map<String,Object>> maps = new ArrayList<>();

        //uuid
        String ordersuuid = UUID.randomUUID().toString().replace("-","");

        for (int i=0;i<goodsLst.size();i++){
            Map<String,Object> orderDetail = new HashMap<>();
            String ordersDetailuuid = UUID.randomUUID().toString().replace("-","");
            orderDetail.put("uuid",ordersDetailuuid);
            orderDetail.put("goodsuuid",goodsLst.get(i).get("uuid"));
            orderDetail.put("goodsname",goodsLst.get(i).get("name"));
            orderDetail.put("price",goodsLst.get(i).get("outprice"));
            orderDetail.put("num",goodsLst.get(i).get("num"));
            orderDetail.put("money",goodsLst.get(i).get("money"));
            orderDetail.put("state","未入库");
            orderDetail.put("ordersuuid",ordersuuid);
            maps.add(orderDetail);
        }

        ordersVo.setUuid(ordersuuid);
        //createtime
        ordersVo.setCreatetime(new Date());
        //creater
        Emp emp = (Emp) session.getAttribute("emp");

        //下单人改成当前登录用户
        ordersVo.setCreater("03805c98ff7e11e887f000e04c824916");

        ordersService.addOrders(ordersVo,maps);

        String message = "添加成功";

        map.put("message",message);
        map.put("code",1);

        return map;
    }
}