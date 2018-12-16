package com.zking.erp.basic.contoller;

import com.zking.erp.basic.model.GoodsType;
import com.zking.erp.basic.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Autowired
    private IGoodsTypeService goodsTypeService;

    @RequestMapping("/queryGoodsTypePager")
    @ResponseBody
    public Map<String,Object> queryGoodsTypePager(GoodsType goodsType){
        List<GoodsType> goodsTypes = goodsTypeService.queryGoodsType(goodsType);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",10);
        map.put("data",goodsTypes);

        return map;
    }

}
