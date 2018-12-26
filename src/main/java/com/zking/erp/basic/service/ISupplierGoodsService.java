package com.zking.erp.basic.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.SupplierGoods;
import com.zking.erp.basic.vo.SupplierGoodsVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface ISupplierGoodsService {
    int insert(SupplierGoods record);

    int insertSelective(SupplierGoods record);

    List<Map<String,Object>> querySupplierGoodsPager(SupplierGoodsVo supplierGoodsVo, PageBean pageBean);

    int editSupplierGoods(SupplierGoods supplierGoods);

    int delSupplierGoods(SupplierGoods supplierGoods);
}