package com.zking.erp.stock.controller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.stock.service.IStoreDetailService;
import com.zking.erp.stock.vo.StoredetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stock")
public class StoreDetailController {

    @Autowired
    private IStoreDetailService storeDetailService;

    @RequestMapping("/queryStoreLikePage")
    @ResponseBody
    public Map<String ,Object> queryStoreLikePage(String sname,String gname, HttpServletRequest req){

        StoredetailVo storedetailVo = new StoredetailVo();
        Store store = new Store();
        store.setName(sname);
        Goods goods = new Goods();
        goods.setName(gname);
        storedetailVo.setStore(store);
        storedetailVo.setGoods(goods);

        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);
        List<Map<String, Object>> list = storeDetailService.queryStoreLikePager(storedetailVo,pageBean);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("meg","");
        map.put("count",pageBean.getTotal());
        map.put("data",list);

        return map;
    }

}
