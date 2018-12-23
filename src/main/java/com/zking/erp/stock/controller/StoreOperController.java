package com.zking.erp.stock.controller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.service.IStoreOperService;
import com.zking.erp.stock.vo.StoreOperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stock")
public class StoreOperController {

    @Autowired
    private IStoreOperService storeOperService;



    @RequestMapping("/queryRecordsPager")
    @ResponseBody
    public Map<String,Object> queryRecordsPager(String empName, String sname, String gname, Integer num, HttpServletRequest req){
        StoreOperVo storeOperVo = new StoreOperVo();
        Goods goods = new Goods();
        Store store = new Store();
        Emp emp = new Emp();
        StoreDetail storeDetail = new StoreDetail();
        emp.setName(empName);
        store.setName(sname);
        goods.setName(gname);
        storeDetail.setNum(num);
        storeOperVo.setEmp(emp);
        storeOperVo.setGoods(goods);
        storeOperVo.setStore(store);
        storeOperVo.setStoreDetail(storeDetail);
        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        List<Map<String, Object>> list = storeOperService.queryRecordsPager(storeOperVo, pageBean);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("meg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);
        return map;
    }
}
