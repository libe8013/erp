package com.zking.erp.personnel.contoller;

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
import com.zking.erp.market.vo.OrdersVo;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.personnel.model.ReturnOrderDetail;
import com.zking.erp.personnel.model.ReturnOrders;
import com.zking.erp.personnel.service.IReturnOrderDetailService;
import com.zking.erp.personnel.service.IReturnOrdersService;
import com.zking.erp.personnel.vo.ReturnOrdersVo;
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
@RequestMapping("/returnedorders")
public class ReturnedOrdersController {

    @Autowired
    private IReturnOrdersService returnOrdersService;

    @Autowired
    private IReturnOrderDetailService returnOrderDetailService;

    @Autowired
    private IStoreService storeService;

    @Autowired
    private IStoreDetailService storeDetailService;

    @Autowired
    private IStoreOperService storeOperService;

    @Autowired
    private IOrderDetailService orderDetailService;

    /**
     * 采购退货订单登记
     * @param returnOrdersVo
     * @param req
     * @param goodsJson
     * @return
     * @throws IOException
     */
    @RequestMapping("/addReturnedGoods")
    @ResponseBody
    public Map<String,Object> ReturnedGoods(ReturnOrdersVo returnOrdersVo, HttpServletRequest req, String goodsJson) throws IOException{
        Map<String,Object> map = new HashMap<>();
        String message = "登记成功";

        String returnOrdersUUID = UUID.randomUUID().toString().replace("-","");

        HttpSession session = req.getSession();

        ObjectMapper mapper = new ObjectMapper();

        Boolean b = true;

        ReturnOrderDetail returnOrderDetail = new ReturnOrderDetail();
        returnOrderDetail.setStoreuuid(returnOrdersVo.getStoreuuid());

        List<Map<String, Object>> maps = mapper.readValue(goodsJson, new TypeReference<List<Map<String, Object>>>() {});
        List<Map<String,Object>> maps1 = new ArrayList<>();
        for (Map<String, Object> m : maps) {
                String orderdetailUUID = m.get("orderdetailUUID").toString();

                OrderDetail orderDetail2 = orderDetailService.selectByPrimaryKey(orderdetailUUID);
                String uuid = m.get("uuid").toString();
                returnOrderDetail.setGoodsuuid(uuid);
                returnOrderDetail.setStoreuuid(orderDetail2.getStoreuuid());
                List<Map<String,Object>> returnOrderDetails = returnOrderDetailService.queryGoodsStore(returnOrderDetail);
                for (Map<String,Object> orderDetail : returnOrderDetails) {
                    if(orderDetail!=null){
                        int num = Integer.parseInt(m.get("num").toString())+Integer.parseInt(orderDetail.get("num").toString());
                        int storeNum = Integer.parseInt(orderDetail.get("storeNum").toString());
                        if (num > storeNum) {
                            message = "商品" + m.get("name") + "已登记,且退货数量大于仓库库存";
                            b = false;
                        }
                    }
                }


            if(b){
                Map<String,Object> m1 = new HashMap<>();
                String returnOrdersDetailUUID = UUID.randomUUID().toString().replace("-","");
                m1.put("uuid",returnOrdersDetailUUID);
                m1.put("goodsuuid",m.get("uuid"));
                m1.put("goodsname",m.get("name"));
                m1.put("price",m.get("inprice"));
                m1.put("num",m.get("num"));
                m1.put("money",m.get("money"));
                m1.put("endtime",orderDetail2.getEndtime());
                m1.put("ender",orderDetail2.getEnder());
                m1.put("storeuuid",orderDetail2.getStoreuuid());
                m1.put("state","未出库");
                m1.put("ordersuuid",returnOrdersUUID);
                maps1.add(m1);
            }

        }

        if(b) {
            Emp emp = (Emp) session.getAttribute("emp");

            //uuid 有
            returnOrdersVo.setUuid(returnOrdersUUID);
            //生成日期
            returnOrdersVo.setCreatetime(new Date());
            //下单员
            returnOrdersVo.setCreater(emp.getUuid());

            try {
                returnOrdersService.addReturnOrders(returnOrdersVo, maps1);
            } catch (Exception e) {
                e.printStackTrace();
                message = "登记失败";
            }
        }

        map.put("message",message);
        map.put("success",b);

        return map;
    }

    @RequestMapping("/queryReturnOrdersPager")
    @ResponseBody
    public Map<String,Object> queryReturnOrdersPager(ReturnOrders returnOrders,HttpServletRequest req) throws ParseException {
        Map<String,Object> map = new HashMap<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
    public Map<String,Object> Audit(ReturnOrders returnOrders,String storeuuid,String json, HttpServletRequest req) throws IOException {
        Map<String,Object> map = new HashMap<>();
        String message = "审核退货成功";

        boolean b = true;

        HttpSession session = req.getSession();

        Emp emp = (Emp) session.getAttribute("emp");

        returnOrders.setChecktime(new Date());

        returnOrders.setChecker(emp.getUuid());

//        if(!orders.getCreater().equals(emp.getUuid())){
//            orders.setCreater(null);
        try {
            if(b){
                returnOrdersService.updateByPrimaryKeySelective(returnOrders);
            }
        } catch (Exception e) {
            message = "审核退货失败";
        }
//        }else{
//            message = "不能审核自己的订单";
//        }



        map.put("message",message);

        return map;
    }

    @RequestMapping("/returnMarketStorage")
    @ResponseBody
    public Map<String,Object> returnMarketStorage(ReturnOrderDetail returnOrderDetail,HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();
        HttpSession session = req.getSession();

        String StoreDetailUUID = UUID.randomUUID().toString().replace("-","");

        Store store = storeService.selectByPrimaryKey(returnOrderDetail.getStoreuuid());

        Emp emp = (Emp) session.getAttribute("emp");


        String message = null;
        Boolean b = true;
        try {
            returnOrderDetail.setEndtime(new Date());
            returnOrderDetail.setState("已入库");
            returnOrderDetail.setStoreuuid(store.getUuid());
            returnOrderDetail.setEnder(store.getEmpuuid());
            returnOrderDetailService.updateByPrimaryKeySelective(returnOrderDetail);

            ReturnOrderDetail oDetail = new ReturnOrderDetail();
            oDetail.setOrdersuuid(returnOrderDetail.getOrdersuuid());
            List<ReturnOrderDetail> orderDetails = returnOrderDetailService.queryOrderDetail(oDetail);
            for (ReturnOrderDetail detail : orderDetails) {
                if(detail.getState().equals("未入库")){
                    b = false;
                    break;
                }
            }

            if(b){
                ReturnOrders orders = new ReturnOrders();
                orders.setUuid(returnOrderDetail.getOrdersuuid());
                orders.setEnder(store.getEmpuuid());
                orders.setEndtime(new Date());
                orders.setState("已入库");
                returnOrdersService.updateByPrimaryKeySelective(orders);
            }

            com.zking.erp.stock.model.StoreDetail storeDetail = new StoreDetail();
            storeDetail.setUuid(StoreDetailUUID);
            storeDetail.setStoreuuid(store.getUuid());
            storeDetail.setGoodsuuid(returnOrderDetail.getGoodsuuid());
            storeDetail.setNum(returnOrderDetail.getNum());
            StoreDetail storeDetail1 = storeDetailService.querySingleStoreDetail(storeDetail);
            if(null!=storeDetail1){
                storeDetail1.setNum(storeDetail1.getNum()+storeDetail.getNum());
                storeDetailService.updateByPrimaryKeySelective(storeDetail1);

//                storeDetailService.insert(storeDetail);
                StoreOper storeOper = new StoreOper();
                storeOper.setUuid(UUID.randomUUID().toString().replace("-",""));
                storeOper.setEmpuuid(emp.getUuid());
                storeOper.setStoreuuid(store.getUuid());
                storeOper.setGoodsuuid(returnOrderDetail.getGoodsuuid());
                storeOper.setNum(storeDetail.getNum());
                storeOper.setOpertime(new Date());
                storeOper.setType("入库");
                storeOperService.insert(storeOper);
            }

            message = "入库成功";
        } catch (Exception e) {
            message = "入库失败";
        }


        map.put("message",message);
        map.put("close",b);

        return map;
    }

    @RequestMapping("/returnStorage")
    @ResponseBody
    public Map<String,Object> returnStorage(ReturnOrderDetail returnOrderDetail,HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();
        HttpSession session = req.getSession();

        String StoreDetailUUID = UUID.randomUUID().toString().replace("-","");

        Store store = storeService.selectByPrimaryKey(returnOrderDetail.getStoreuuid());

        Emp emp = (Emp) session.getAttribute("emp");


        String message = null;
        Boolean b = true;
        try {
            returnOrderDetail.setEndtime(new Date());
            returnOrderDetail.setState("已出库");
            returnOrderDetail.setStoreuuid(store.getUuid());
            returnOrderDetail.setEnder(store.getEmpuuid());
            returnOrderDetailService.updateByPrimaryKeySelective(returnOrderDetail);

            ReturnOrderDetail oDetail = new ReturnOrderDetail();
            oDetail.setOrdersuuid(returnOrderDetail.getOrdersuuid());
            List<ReturnOrderDetail> orderDetails = returnOrderDetailService.queryOrderDetail(oDetail);
            for (ReturnOrderDetail detail : orderDetails) {
                if(detail.getState().equals("未出库")){
                    b = false;
                    break;
                }
            }

            if(b){
                ReturnOrders orders = new ReturnOrders();
                orders.setUuid(returnOrderDetail.getOrdersuuid());
                orders.setEnder(store.getEmpuuid());
                orders.setEndtime(new Date());
                orders.setState("已出库");
                returnOrdersService.updateByPrimaryKeySelective(orders);
            }

            com.zking.erp.stock.model.StoreDetail storeDetail = new StoreDetail();
            storeDetail.setUuid(StoreDetailUUID);
            storeDetail.setStoreuuid(store.getUuid());
            storeDetail.setGoodsuuid(returnOrderDetail.getGoodsuuid());
            storeDetail.setNum(returnOrderDetail.getNum());
            StoreDetail storeDetail1 = storeDetailService.querySingleStoreDetail(storeDetail);
            if(null!=storeDetail1){
                    storeDetail1.setNum(storeDetail1.getNum()-storeDetail.getNum());
                    storeDetailService.updateByPrimaryKeySelective(storeDetail1);

//                    storeDetailService.insert(storeDetail);
                    StoreOper storeOper = new StoreOper();
                    storeOper.setUuid(UUID.randomUUID().toString().replace("-",""));
                    storeOper.setEmpuuid(emp.getUuid());
                    storeOper.setStoreuuid(store.getUuid());
                    storeOper.setGoodsuuid(returnOrderDetail.getGoodsuuid());
                    storeOper.setNum(storeDetail.getNum());
                    storeOper.setOpertime(new Date());
                    storeOper.setType("出库");
                    storeOperService.insert(storeOper);
            }

            message = "出库成功";
        } catch (Exception e) {
            message = "出库失败";
        }


        map.put("message",message);
        map.put("close",b);

        return map;
    }

    /**
     * 删除订单
     * @param returnOrdersUUID
     * @return
     */
    @RequestMapping("/delReturnOrders")
    @ResponseBody
    public Map<String,Object> delReturnOrders(String returnOrdersUUID){
        Map<String,Object> map = new HashMap<>();
        String message = "删除成功";

        try {
            returnOrderDetailService.delReturnOrderdetail(returnOrdersUUID);
            returnOrdersService.deleteByPrimaryKey(returnOrdersUUID);
        } catch (Exception e) {
            message = "删除失败";
        }

        map.put("message",message);

        return map;
    }

    /**
     * 销售退货订单登记
     * @param returnOrdersVo
     * @param req
     * @param goodsJson
     * @return
     * @throws IOException
     */
    @RequestMapping("/ReturnedMarketOrderGoods")
    @ResponseBody
    public Map<String,Object> ReturnedMarketOrderGoods(ReturnOrdersVo returnOrdersVo, HttpServletRequest req, String goodsJson) throws IOException{
        Map<String,Object> map = new HashMap<>();
        String message = "登记成功";

        String returnOrdersUUID = UUID.randomUUID().toString().replace("-","");

        HttpSession session = req.getSession();

        ObjectMapper mapper = new ObjectMapper();

        Boolean b = true;

        List<Map<String, Object>> maps = mapper.readValue(goodsJson, new TypeReference<List<Map<String, Object>>>() {});
        List<Map<String,Object>> maps1 = new ArrayList<>();
        for (Map<String, Object> m : maps) {
            String orderdetailUUID = m.get("orderdetailUUID").toString();

            OrderDetail orderDetail = orderDetailService.selectByPrimaryKey(orderdetailUUID);
            orderDetail.setUuid(orderdetailUUID);
//            orderDetail.setState("退货中");
            orderDetail.setNum(orderDetail.getNum()-Integer.parseInt(m.get("num").toString()));
            orderDetail.setMoney(orderDetail.getMoney()-Integer.parseInt(m.get("money").toString()));

            orderDetailService.updateByPrimaryKeySelective(orderDetail);

            if(b){
                Map<String,Object> m1 = new HashMap<>();
                String returnOrdersDetailUUID = UUID.randomUUID().toString().replace("-","");
                m1.put("uuid",returnOrdersDetailUUID);
                m1.put("goodsuuid",m.get("uuid"));
                m1.put("goodsname",m.get("name"));
                m1.put("price",m.get("outprice"));
                m1.put("num",m.get("num"));
                m1.put("money",m.get("money"));
                OrderDetail orderDetail1 = orderDetailService.selectByPrimaryKey(orderdetailUUID);
                m1.put("storeuuid",orderDetail1.getStoreuuid());
                m1.put("state","未入库");
                m1.put("ordersuuid",returnOrdersUUID);
                maps1.add(m1);
            }

        }

        if(b) {
            Emp emp = (Emp) session.getAttribute("emp");



            //uuid
            returnOrdersVo.setUuid(returnOrdersUUID);
            //生成日期
            returnOrdersVo.setCreatetime(new Date());
            //下单员
            returnOrdersVo.setCreater(emp.getUuid());

            try {
                returnOrdersService.addReturnOrders(returnOrdersVo, maps1);
            } catch (Exception e) {
                e.printStackTrace();
                message = "登记失败";
            }
        }

        map.put("message",message);
        map.put("success",b);

        return map;
    }

}