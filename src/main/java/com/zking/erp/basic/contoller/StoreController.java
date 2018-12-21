package com.zking.erp.basic.contoller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Store;
import com.zking.erp.basic.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private IStoreService storeService;

    @RequestMapping("/queryStoreLikePager")
    @ResponseBody
    public Map<String,Object> queryStoreLikePager(Store store, HttpServletRequest req){
        Map<String,Object> map = new HashMap<>();

        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);

        List<Store> stores = storeService.queryStoreLikePager(store, pageBean);

        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",stores);

        return map;
    }

    @RequestMapping("/addStore")
    @ResponseBody
    public Map<String,Object> addStore(Store store){
        Map<String,Object> map = new HashMap<>();
        String message = "添加成功";

        store.setUuid(UUID.randomUUID().toString().replace("-",""));

        try {
            storeService.insert(store);
        } catch (Exception e) {
            message = "添加失败";
        }

        map.put("message",message);

        return map;
    }

    @RequestMapping("/editStore")
    @ResponseBody
    public Map<String,Object> editStore(Store store){
        Map<String,Object> map = new HashMap<>();

        String message = "修改成功";

        try {
            storeService.updateByPrimaryKeySelective(store);
        } catch (Exception e) {
            message = "修改异常";
        }

        map.put("message",message);

        return map;
    }

    @RequestMapping("/delStore")
    @ResponseBody
    public Map<String,Object> delStore(Store store){
        Map<String,Object> map = new HashMap<>();

        String message = "删除成功";

        try {
            storeService.deleteByPrimaryKey(store.getUuid());
        } catch (Exception e) {
            message = "删除异常";
        }

        map.put("message",message);

        return map;
    }

}
