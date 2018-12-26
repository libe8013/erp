package com.zking.erp.personnel.contoller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.erp.base.util.PageBean;
import com.zking.erp.market.model.Orders;
import com.zking.erp.market.service.IOrdersService;
import com.zking.erp.market.vo.OrdersVo;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.model.ReturnOrderDetail;
import com.zking.erp.personnel.model.ReturnOrders;
import com.zking.erp.personnel.service.IReturnOrdersService;
import com.zking.erp.personnel.vo.ReturnOrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/returnedorders")
public class ReturnedOrdersController {

    @Autowired
    private IReturnOrdersService returnOrdersService;

    @RequestMapping("/addReturnedGoods")
    @ResponseBody
    public Map<String,Object> ReturnedGoods(ReturnOrdersVo returnOrdersVo, HttpServletRequest req, String goodsJson) throws IOException{
        Map<String,Object> map = new HashMap<>();
        String message = "登记成功";
        String returnOrdersUUID = UUID.randomUUID().toString().replace("-","");

        HttpSession session = req.getSession();

        ObjectMapper mapper = new ObjectMapper();

        List<Map<String, Object>> maps = mapper.readValue(goodsJson, new TypeReference<List<Map<String, Object>>>() {});
        List<Map<String,Object>> maps1 = new ArrayList<>();
        for (Map<String, Object> m : maps) {
            Map<String,Object> m1 = new HashMap<>();
            String returnOrdersDetailUUID = UUID.randomUUID().toString().replace("-","");
            m1.put("uuid",returnOrdersDetailUUID);
            m1.put("goodsuuid",m.get("uuid"));
            m1.put("goodsname",m.get("name"));
            m1.put("price",m.get("outprice"));
            m1.put("num",m.get("num"));
            m1.put("money",m.get("money"));
            m1.put("state","未出库");
            m1.put("ordersuuid",returnOrdersUUID);
            maps1.add(m1);
        }

        Emp emp = (Emp) session.getAttribute("emp");

        //uuid 有
        returnOrdersVo.setUuid(returnOrdersUUID);
        //生成日期
        returnOrdersVo.setCreatetime(new Date());
        //下单员
        returnOrdersVo.setCreater(emp.getUuid());

        try {
            returnOrdersService.addReturnOrders(returnOrdersVo,maps1);
        } catch (Exception e) {
            e.printStackTrace();
            message = "登记失败";
        }

        map.put("message",message);

        return map;
    }

    @RequestMapping("/queryReturnOrdersPager")
    @ResponseBody
    public Map<String,Object> queryReturnOrdersPager(ReturnOrders returnOrders,HttpServletRequest req) throws ParseException {
        Map<String,Object> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);

        List<ReturnOrders> returnOrders1 = returnOrdersService.queryReturnOrdersPager(returnOrders, pageBean);

        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",returnOrders1);

        return map;
    }

    @RequestMapping("/Audit")
    @ResponseBody
    public Map<String,Object> Audit(ReturnOrders returnOrders, HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();
        String message = "审核退货成功";

        HttpSession session = req.getSession();

        Emp emp = (Emp) session.getAttribute("emp");

        returnOrders.setChecktime(new Date());

        returnOrders.setChecker(emp.getUuid());

//        if(!orders.getCreater().equals(emp.getUuid())){
//            orders.setCreater(null);
        try {
            returnOrdersService.updateByPrimaryKeySelective(returnOrders);
        } catch (Exception e) {
            message = "审核退货失败";
        }
//        }else{
//            message = "不能审核自己的订单";
//        }



        map.put("message",message);

        return map;
    }

}