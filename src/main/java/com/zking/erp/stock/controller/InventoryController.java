package com.zking.erp.stock.controller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.service.IInventoryService;
import com.zking.erp.stock.vo.InventoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stock")
public class InventoryController {

    @Autowired
    private IInventoryService iInventoryService;

    @RequestMapping("/queryInventoryPager")
    @ResponseBody
    public Map<String,Object> queryInventoryPager(InventoryVo inventoryVo,String sname, String gname, Integer stNum, String ename, HttpServletRequest req){
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
        PageBean pageBean = new PageBean();
        List<Map<String, Object>> list = iInventoryService.queryInventoryPager(inventoryVo, pageBean);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("meg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;

    }

}
