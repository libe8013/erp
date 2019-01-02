package com.zking.erp.market.contoller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.basic.service.IStoreService;
import com.zking.erp.market.model.OrderDetail;
import com.zking.erp.market.model.Orders;
import com.zking.erp.market.service.IOrderDetailService;
import com.zking.erp.market.service.IOrdersService;
import com.zking.erp.market.vo.OrderDetailVo;
import com.zking.erp.market.vo.OrdersVo;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.model.StoreOper;
import com.zking.erp.stock.service.IStoreDetailService;
import com.zking.erp.stock.service.IStoreOperService;
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
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @Autowired
    private IStoreService storeService;

    @Autowired
    private IStoreDetailService storeDetailService;

    @Autowired
    private IStoreOperService storeOperService;

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
    public Map<String,Object> queryPurchasePager(Orders orders,HttpServletRequest req) throws ParseException {
        Map<String,Object> map = new HashMap<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);

        List<Orders> orders1 = ordersService.queryOrderPurchasePager(orders, pageBean);

        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",orders1);

        return map;
    }

    @RequestMapping("/addOrdersMarket")
    @ResponseBody
    public Map<String,Object> addOrdersMarket(OrdersVo goods, HttpServletRequest req, String goodsJson) throws IOException {
        Map<String,Object> map = new HashMap<String,Object>();

        HttpSession session = req.getSession();

        ObjectMapper mapper = new ObjectMapper();

        List<Map<String,Object>> goodsLst = mapper.readValue(goodsJson, new TypeReference<List<Map<String,Object>>>() {});

        List<Map<String,Object>> maps = new ArrayList<>();

        //uuid
        String ordersuuid = UUID.randomUUID().toString().replace("-","");

        Boolean b=true;

        for (int i=0;i<goodsLst.size();i++){
            OrderDetail od = new OrderDetail();
            od.setGoodsuuid(goodsLst.get(i).get("uuid").toString());
            od.setSupplieruuid(goods.getSupplieruuid());
            List<OrderDetail> orderDetails = orderDetailService.queryGoodsOrderdetailMarket(od);
            if(orderDetails.size()!=0){
                b = false;
                for (OrderDetail orderDetail : orderDetails) {
                    orderDetail.setNum(orderDetail.getNum()+Integer.parseInt(goodsLst.get(i).get("num").toString()));
                    orderDetail.setMoney(orderDetail.getMoney()+(Float.parseFloat(goodsLst.get(i).get("money").toString())));
                    orderDetailService.updateByPrimaryKeySelective(orderDetail);
                }
            }
            Map<String,Object> orderDetail = new HashMap<>();
            String ordersDetailuuid = UUID.randomUUID().toString().replace("-","");
            orderDetail.put("uuid",ordersDetailuuid);
            orderDetail.put("goodsuuid",goodsLst.get(i).get("uuid"));
            orderDetail.put("goodsname",goodsLst.get(i).get("name"));
            orderDetail.put("price",goodsLst.get(i).get("inprice"));
            orderDetail.put("num",goodsLst.get(i).get("num"));
            orderDetail.put("money",goodsLst.get(i).get("money"));
            orderDetail.put("state",goodsLst.get(i).get("state"));
            orderDetail.put("ordersuuid",ordersuuid);
            maps.add(orderDetail);
        }

        goods.setUuid(ordersuuid);
        //createtime
        goods.setCreatetime(new Date());
        //creater
        Emp emp = (Emp) session.getAttribute("emp");

        //下单人改成当前登录用户
        goods.setCreater(emp.getUuid());

        if(b){
            ordersService.addOrders(goods,maps);
        }

        String message = "添加成功";

        map.put("message",message);
        map.put("code",1);

        return map;
    }

    @RequestMapping("/addOrders")
    @ResponseBody
    public Map<String,Object> addOrders(OrdersVo goods, HttpServletRequest req, String goodsJson) throws IOException {
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
            orderDetail.put("price",goodsLst.get(i).get("inprice"));
            orderDetail.put("num",goodsLst.get(i).get("num"));
            orderDetail.put("money",goodsLst.get(i).get("money"));
            orderDetail.put("state",goodsLst.get(i).get("state"));
            orderDetail.put("ordersuuid",ordersuuid);
            maps.add(orderDetail);
        }

        goods.setUuid(ordersuuid);
        //createtime
        goods.setCreatetime(new Date());
        //creater
        Emp emp = (Emp) session.getAttribute("emp");

        //下单人改成当前登录用户
        goods.setCreater(emp.getUuid());

        ordersService.addOrders(goods,maps);

        String message = "添加成功";

        map.put("message",message);
        map.put("code",1);

        return map;
    }

    @RequestMapping("/Audit")
    @ResponseBody
    public Map<String,Object> Audit(Orders orders,HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();
        String message = "审核成功";

        HttpSession session = req.getSession();

        Emp emp = (Emp) session.getAttribute("emp");

        orders.setChecktime(new Date());

        orders.setChecker(emp.getUuid());

//        if(!orders.getCreater().equals(emp.getUuid())){
//            orders.setCreater(null);
            try {
                ordersService.updateByPrimaryKeySelective(orders);
            } catch (Exception e) {
                message = "审核失败";
            }
//        }else{
//            message = "不能审核自己的订单";
//        }



        map.put("message",message);

        return map;
    }

    @RequestMapping("/Affirm")
    @ResponseBody
    public Map<String,Object> Affirm(Orders orders,HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();
        String message = "确定订单成功";

        HttpSession session = req.getSession();

        Emp emp = (Emp) session.getAttribute("emp");

        orders.setStarttime(new Date());

        orders.setStarter(emp.getUuid());

//        if(!orders.getCreater().equals(emp.getUuid())){
//            orders.setCreater(null);
            try {
                ordersService.updateByPrimaryKeySelective(orders);
            } catch (Exception e) {
                message = "订单确定失败";
            }
//        }else{
//            message = "不能审核自己的订单";
//        }



        map.put("message",message);

        return map;
    }

    @RequestMapping("/storage")
    @ResponseBody
    public Map<String,Object> Storage(OrderDetail orderDetail,HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();
        HttpSession session = req.getSession();

        String StoreDetailUUID = UUID.randomUUID().toString().replace("-","");

        Store store = storeService.selectByPrimaryKey(orderDetail.getStoreuuid());

        Emp emp = (Emp) session.getAttribute("emp");


        String message = null;
        Boolean b = true;
        try {
            orderDetail.setEndtime(new Date());
            orderDetail.setState("已入库");
            orderDetail.setStoreuuid(store.getUuid());
            orderDetail.setEnder(store.getEmpuuid());
            orderDetailService.updateByPrimaryKeySelective(orderDetail);

            OrderDetailVo oDetail = new OrderDetailVo();
            oDetail.setOrdersuuid(orderDetail.getOrdersuuid());
            List<OrderDetail> orderDetails = orderDetailService.queryOrderDetail(oDetail);
            for (OrderDetail detail : orderDetails) {
                if(detail.getState().equals("未入库")){
                    b = false;
                    break;
                }
            }

            if(b){
                Orders orders = new Orders();
                orders.setUuid(orderDetail.getOrdersuuid());
                orders.setEnder(store.getEmpuuid());
                orders.setEndtime(new Date());
                orders.setState("已入库");
                ordersService.updateByPrimaryKeySelective(orders);
            }

            com.zking.erp.stock.model.StoreDetail storeDetail = new StoreDetail();
            storeDetail.setUuid(StoreDetailUUID);
            storeDetail.setStoreuuid(store.getUuid());
            storeDetail.setGoodsuuid(orderDetail.getGoodsuuid());
            storeDetail.setNum(orderDetail.getNum());
            StoreDetail storeDetail1 = storeDetailService.querySingleStoreDetail(storeDetail);
            if(null!=storeDetail1){
                storeDetail1.setNum(storeDetail1.getNum()+storeDetail.getNum());
                storeDetailService.updateByPrimaryKeySelective(storeDetail1);
            }else{
                storeDetailService.insert(storeDetail);
            }

            StoreOper storeOper = new StoreOper();
            storeOper.setUuid(UUID.randomUUID().toString().replace("-",""));
            storeOper.setEmpuuid(emp.getUuid());
            storeOper.setStoreuuid(store.getUuid());
            storeOper.setGoodsuuid(orderDetail.getGoodsuuid());
            storeOper.setNum(storeDetail.getNum());
            storeOper.setOpertime(new Date());
            storeOper.setType("入库");
            storeOperService.insert(storeOper);
            message = "入库成功";
        } catch (Exception e) {
            message = "入库失败";
        }


        map.put("message",message);
        map.put("close",b);

        return map;
    }

    @RequestMapping("/Marketstorage")
    @ResponseBody
    public Map<String,Object> MarketStorage(OrderDetail orderDetail,HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();
        HttpSession session = req.getSession();

        Store store = storeService.selectByPrimaryKey(orderDetail.getStoreuuid());

        Emp emp = (Emp) session.getAttribute("emp");


        String message = null;
        Boolean b = true;
        try {
            orderDetail.setEndtime(new Date());
            orderDetail.setState("已出库");
            orderDetail.setStoreuuid(store.getUuid());
            orderDetail.setEnder(store.getEmpuuid());
            orderDetailService.updateByPrimaryKeySelective(orderDetail);

            OrderDetailVo oDetail = new OrderDetailVo();
            oDetail.setOrdersuuid(orderDetail.getOrdersuuid());
            List<OrderDetail> orderDetails = orderDetailService.queryOrderDetail(oDetail);
            for (OrderDetail detail : orderDetails) {
                if(detail.getState().equals("未出库")){
                    b = false;
                    break;
                }
            }

            if(b){
                Orders orders = new Orders();
                orders.setUuid(orderDetail.getOrdersuuid());
                orders.setEnder(store.getEmpuuid());
                orders.setEndtime(new Date());
                orders.setState("已出库");
                ordersService.updateByPrimaryKeySelective(orders);
            }

            com.zking.erp.stock.model.StoreDetail storeDetail = new StoreDetail();
//            storeDetail.setUuid(StoreDetailUUID);
            storeDetail.setStoreuuid(store.getUuid());
            storeDetail.setGoodsuuid(orderDetail.getGoodsuuid());
            storeDetail.setNum(orderDetail.getNum());
            StoreDetail storeDetail1 = storeDetailService.querySingleStoreDetail(storeDetail);
            if(null!=storeDetail1){
                storeDetail1.setNum(storeDetail1.getNum()-storeDetail.getNum());
                storeDetailService.updateByPrimaryKeySelective(storeDetail1);
            }else{
                storeDetailService.insert(storeDetail);
            }

            StoreOper storeOper = new StoreOper();
            storeOper.setUuid(UUID.randomUUID().toString().replace("-",""));
            storeOper.setEmpuuid(emp.getUuid());
            storeOper.setStoreuuid(store.getUuid());
            storeOper.setGoodsuuid(orderDetail.getGoodsuuid());
            storeOper.setNum(storeDetail.getNum());
            storeOper.setOpertime(new Date());
            storeOper.setType("出库");
            storeOperService.insert(storeOper);
            message = "出库成功";
        } catch (Exception e) {
            message = "入库失败";
        }


        map.put("success",b);
        map.put("message",message);

        return map;
    }

    @RequestMapping("/queryClientGoods")
    @ResponseBody
    public List<Map<String,Object>> queryClientGoods(Orders orders){
        List<Map<String,Object>> orderDetails = ordersService.queryClientGoods(orders);

        return orderDetails;
    }

    @RequestMapping("/querySupplierGoods")
    @ResponseBody
    public List<Map<String,Object>> querySupplierGoods(Orders orders){
        List<Map<String,Object>> orderDetails = ordersService.querySupplierGoods(orders);

        return orderDetails;
    }

}