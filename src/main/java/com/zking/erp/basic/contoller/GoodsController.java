package com.zking.erp.basic.contoller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Supplier;
import com.zking.erp.basic.model.SupplierGoods;
import com.zking.erp.basic.service.IGoodsService;
import com.zking.erp.basic.service.ISupplierGoodsService;
import com.zking.erp.basic.vo.SupplierGoodsVo;
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
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private ISupplierGoodsService supplierGoodsService;

    @RequestMapping("/queryGoodsLikePager")
    @ResponseBody
    public Map<String,Object> queryGoodsPager(Goods good, SupplierGoodsVo supplierGoodsVo, HttpServletRequest req){

        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);

        supplierGoodsVo.setGoods(good);

//        List<Goods> goods = goodsService.queryGoodsLikePager(good,pageBean);
        List<Map<String,Object>> supplierGoods = supplierGoodsService.querySupplierGoodsPager(supplierGoodsVo,pageBean);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",supplierGoods);

        return map;
    }

    @RequestMapping("/addGoods")
    @ResponseBody
    public Map<String,Object> addGoods(Goods goods, SupplierGoods supplierGoods){
        String message = "添加成功";

        goods.setUuid(UUID.randomUUID().toString().replace("-",""));

        Map<String,Object> map  = new HashMap<>();

        try {
            supplierGoods.setGoodsuuid(goods.getUuid());
            goodsService.insert(goods);
            supplierGoodsService.insert(supplierGoods);
        } catch (Exception e) {
            message = "添加失败";
        }

        map.put("meg",message);

        return map;
    }

    @RequestMapping("/delGoods")
    @ResponseBody
    public Map<String,Object> delGoods(Goods goods,SupplierGoods supplierGoods){
        String message = "删除成功";

        Map<String,Object> map  = new HashMap<>();

        try {
            supplierGoods.setGoodsuuid(goods.getUuid());
            supplierGoodsService.delSupplierGoods(supplierGoods);
            goodsService.deleteByPrimaryKey(goods.getUuid());
        } catch (Exception e) {
            e.printStackTrace();
            message = "删除失败";
        }

        map.put("message",message);
        return map;
    }

    @RequestMapping("/editGoods")
    @ResponseBody
    public Map<String,Object> editGoods(Goods goods,SupplierGoods supplierGoods){
        String message = "保存成功";

        Map<String,Object> map  = new HashMap<>();

        try {
            goodsService.updateByPrimaryKeySelective(goods);
            supplierGoods.setGoodsuuid(goods.getUuid());
            supplierGoodsService.editSupplierGoods(supplierGoods);
        } catch (Exception e) {
            message = "保存失败";
        }

        map.put("message",message);
        return map;
    }

}
