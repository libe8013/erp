package com.zking.erp.stock.controller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.stock.model.Inventory;
import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.service.IInventoryService;
import com.zking.erp.stock.vo.InventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stock")
public class InventoryController {

    @Autowired
    private IInventoryService iInventoryService;


    /**
     * 查询所有
     * @param bjend
     * @param inventoryVo
     * @param sname
     * @param gname
     * @param stNum
     * @param ename
     * @param req
     * @return
     */
    @RequestMapping("/queryInventoryPager")
    @ResponseBody
    public Map<String,Object> queryInventoryPager(Date bjend, InventoryVo inventoryVo, String sname, String gname, Integer stNum, String ename, HttpServletRequest req){
        Goods goods = new Goods();
        Store store = new Store();
        StoreDetail storeDetail = new StoreDetail();
        Emp emp = new Emp();
        store.setName(sname);
        goods.setName(gname);
        storeDetail.setNum(stNum);
        emp.setName(ename);
        inventoryVo.setEmp(emp);
        inventoryVo.setGoods(goods);
        inventoryVo.setStore(store);
        inventoryVo.setStoreDetail(storeDetail);
        inventoryVo.setCreatetime(bjend);
        PageBean pageBean = new PageBean();
        List<Map<String, Object>> list = iInventoryService.queryInventoryPager(inventoryVo, pageBean);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("meg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;

    }

    /**
     * 修改审核状态
     * @param inventory
     * @return
     */
    @RequestMapping("/updAudit")
    @ResponseBody
    public Map<String,Object> updAudit(Inventory inventory){
        String message = "审核成功";
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            iInventoryService.updAudit(inventory);
        } catch (Exception e) {
            e.printStackTrace();
            message="审核失败";
        }

        map.put("message",message);

        return map;
    }


    /**
     * 查询未审核的状态
     * @param bjend
     * @param inventoryVo
     * @param sname
     * @param gname
     * @param stNum
     * @param ename
     * @param req
     * @return
     */
    @RequestMapping("/queryInvWtypePager")
    @ResponseBody
    public Map<String,Object> queryInvWtypePager(Date bjend, InventoryVo inventoryVo, String sname, String gname, Integer stNum, String ename, HttpServletRequest req){
        Goods goods = new Goods();
        Store store = new Store();
        StoreDetail storeDetail = new StoreDetail();
        Emp emp = new Emp();
        store.setName(sname);
        goods.setName(gname);
        storeDetail.setNum(stNum);
        emp.setName(ename);
        inventoryVo.setEmp(emp);
        inventoryVo.setGoods(goods);
        inventoryVo.setStore(store);
        inventoryVo.setStoreDetail(storeDetail);
        inventoryVo.setCreatetime(bjend);
        PageBean pageBean = new PageBean();
        List<Map<String, Object>> list = iInventoryService.queryInvWtypePager(inventoryVo, pageBean);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("meg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;
    }


}
