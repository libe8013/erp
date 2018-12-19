package com.zking.erp.basic.contoller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.GoodsType;
import com.zking.erp.basic.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Autowired
    private IGoodsTypeService goodsTypeService;

    @RequestMapping("/queryGoodsTypePager")
    @ResponseBody
    public Map<String,Object> queryGoodsTypePager(GoodsType goodsType, HttpServletRequest req){

        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);

        List<GoodsType> goodsTypes = goodsTypeService.queryGoodsTypePager(goodsType,pageBean);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",goodsTypes);

        return map;
    }

    @RequestMapping("/addGoodsType")
    @ResponseBody
    public Map<String,Object> addGoodsType(GoodsType goodsType){
        Map<String,Object> map = new HashMap<>();
        String message = "保存成功";

        try {
            goodsType.setUuid(UUID.randomUUID().toString().replace("-",""));
            goodsTypeService.insert(goodsType);
        } catch (Exception e) {
            message = "保存失败";
        }

        map.put("message",message);

        return map;
    }

    @RequestMapping("/delGoodsType")
    @ResponseBody
    public Map<String,Object> delGoodsType(GoodsType goodsType){
        Map<String,Object> map = new HashMap<>();
        String message = "删除成功";

        try {
            goodsTypeService.deleteByPrimaryKey(goodsType.getUuid());
        } catch (Exception e) {
            message = "删除失败";
        }

        map.put("message",message);

        return map;
    }

    @RequestMapping("/editGoodsType")
    @ResponseBody
    public Map<String,Object> editGoodsType(GoodsType goodsType){
        Map<String,Object> map = new HashMap<>();
        String message = "保存成功";

        try {
            goodsTypeService.updateByPrimaryKey(goodsType);
        } catch (Exception e) {
            message = "保存失败";
        }

        map.put("message",message);

        return map;
    }

    @RequestMapping("/queryGoodsTypeSingle")
    @ResponseBody
    public GoodsType queryGoodsTypeSingle(String uuid){

        GoodsType goodsType = goodsTypeService.selectByPrimaryKey(uuid);

        return goodsType;
    }

}
