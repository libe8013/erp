package com.zking.erp.basic.contoller;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Supplier;
import com.zking.erp.basic.service.ISupplierService;
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
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    @RequestMapping("/querySupplierLikePager")
    @ResponseBody
    public Map<String,Object> querySupplierLikePager(Supplier supplier, HttpServletRequest req){

//        supplier.setUuid(UUID.randomUUID().toString().replace("-",""));

        PageBean pageBean = new PageBean();
        pageBean.setRequest(req);

        List<Supplier> goods = supplierService.querySupplierLikePager(supplier,pageBean);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",pageBean.getTotal());
        map.put("data",goods);

        return map;
    }

    @RequestMapping("/addSupplier")
    @ResponseBody
    public Map<String,Object> addSupplier(Supplier supplier){
        String message = "添加成功";

        Map<String,Object> map = new HashMap<>();

        supplier.setUuid(UUID.randomUUID().toString().replace("-",""));

        try {
            supplierService.insert(supplier);
        } catch (Exception e) {
            message = "添加失败";
        }

        map.put("message",message);

        return map;
    }

    @RequestMapping("/delSupplier")
    @ResponseBody
    public Map<String,Object> delSupplier(String uuid){
        Map<String,Object> map = new HashMap<>();

        String message = "删除成功";

        String code = "1";

        try {
            supplierService.deleteByPrimaryKey(uuid);
        } catch (Exception e) {
            message="删除失败";
            code="-1";
        }

        map.put("message",message);
        map.put("code",code);

        return map;
    }

    @RequestMapping("/editSupplier")
    @ResponseBody
    public Map<String,Object> editSupplier(Supplier supplier){
        Map<String,Object> map = new HashMap<>();

        String message = "修改成功";

        try {
            supplierService.updateByPrimaryKeySelective(supplier);
        } catch (Exception e) {
            message="修改失败";
        }

        map.put("message",message);

        return map;
    }

}
