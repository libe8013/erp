package com.zking.erp.stock.controller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.stock.model.Inventory;
import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.service.IInventoryService;
import com.zking.erp.stock.service.IStoreDetailService;
import com.zking.erp.stock.vo.InventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/stock")
public class InventoryController {

    @Autowired
    private IInventoryService iInventoryService;

    @Autowired
    private IStoreDetailService storeDetailService;

//    private IStore

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
    public Map<String,Object> updAudit(Inventory inventory,HttpServletRequest req){
        Emp emp = (Emp) req.getSession().getAttribute("emp");
        String message = "审核成功";
        Map<String,Object> map = new HashMap<String, Object>();
        inventory.setState("已审核");
        boolean b = true;
        try {
            StoreDetail storeDetail = new StoreDetail();
            storeDetail.setGoodsuuid(inventory.getGoodsuuid());
            storeDetail.setStoreuuid(inventory.getStoreuuid());
            StoreDetail storeDetail1 = storeDetailService.querySingleStore(storeDetail);
            if(inventory.getType().equals("0")){
                if(storeDetail1==null){
                    StoreDetail storeDetail2 = new StoreDetail();
                    storeDetail2.setUuid(UUID.randomUUID().toString().replace("-",""));
                    storeDetail2.setNum(inventory.getNum());
                    storeDetail2.setStoreuuid(inventory.getStoreuuid());
                    storeDetail2.setGoodsuuid(inventory.getGoodsuuid());
                    storeDetailService.insert(storeDetail2);
                }else{
                    storeDetail1.setNum(inventory.getNum()+storeDetail1.getNum());
                    storeDetailService.updateByPrimaryKeySelective(storeDetail1);
                }
            }else if (inventory.getType().equals("1")){
                if(storeDetail1.getNum()<inventory.getNum()){
                    message = "审核失败,盘亏数量不可大于库存数量";
                    b = false;
                }
                if(b){
                    storeDetail1.setNum(storeDetail1.getNum()-inventory.getNum());
                    storeDetailService.updateByPrimaryKeySelective(storeDetail1);
                }
            }
            if(b){
                inventory.setChecker(emp.getUuid());
                inventory.setChecktime(new Date());
                iInventoryService.updAudit(inventory);
            }
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

    @RequestMapping("/addnventory")
    @ResponseBody
    public Map<String,Object> addnventory(Inventory  inventory, HttpServletRequest req){
        Map<String,Object> map = new HashMap<String, Object>();
        String message = "登记成功";

        Emp emp = (Emp) req.getSession().getAttribute("emp");

        String uuid = UUID.randomUUID().toString().replace("-","");
        inventory.setUuid(uuid);
        inventory.setCreater(emp.getUuid());
        inventory.setState("未审核");
        inventory.setCreatetime(new Date());
        inventory.setChecker(null);

        try {
            iInventoryService.insert(inventory);
        } catch (Exception e) {
            message = "登记失败";
        }

        map.put("message",message);
        return map;
    }

}
