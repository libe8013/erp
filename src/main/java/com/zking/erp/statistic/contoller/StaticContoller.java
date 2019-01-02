package com.zking.erp.statistic.contoller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.statistic.service.IStaticService;
import com.zking.erp.statistic.vo.StaticVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sales")
public class StaticContoller {
    @Autowired
    private IStaticService staticService;
    private StaticVo staticVo = new StaticVo();


    @RequestMapping("/salesStat")
    @ResponseBody
    public Map<String, Object> salesStatPager(StaticVo staticVo, HttpServletRequest req) {
        PageBean pagebean = new PageBean();
        pagebean.setRequest(req);
        List<Map<String,Object>> list = staticService.salesStatPager(staticVo, pagebean);
        Map<String,Object> map1;
        List<Map<String,Object>> mapList=new ArrayList<>();
        Map<String, Object> map = new HashMap<String, Object>();
        for (Map<String,Object> objectMap:list){
            map1=new HashMap<>();
            map1.put("typename",objectMap.get("typename"));
            map1.put("totalmoney",objectMap.get("totalmoney"));
            mapList.add(map1);
        }
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pagebean.getTotal());
        map.put("data", mapList);
        map.put("success",true);
        return map;
    }

    @RequestMapping("/salesStatMonth")
    @ResponseBody
    public Map<String, Object> salesStatMonthPager(StaticVo staticVo, HttpServletRequest req) {
        PageBean pagebean = new PageBean();
        pagebean.setRequest(req);
        List<Map<String,Object>> list = staticService.salesStatMonthPager(staticVo, pagebean);
        Map<String,Object> map1;
        List<Map<String,Object>> mapList=new ArrayList<>();
        Map<String, Object> map = new HashMap<String, Object>();
        for (Map<String,Object> objectMap:list){
            map1=new HashMap<>();
            map1.put("entime",objectMap.get("endtime"));
            map1.put("totalmoney",objectMap.get("totalmoney"));
            mapList.add(map1);
        }

        map.put("code", 0);
        map.put("msg", "");
       // map.put("count", pagebean.getTotal());
        map.put("data", list);
        return map;
        }
        }

