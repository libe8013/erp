package com.zking.erp.basic.mapper;

import com.zking.erp.basic.model.SupplierGoods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SupplierGoodsMapper {
    int insert(SupplierGoods record);

    int insertSelective(SupplierGoods record);

    int editSupplierGoods(SupplierGoods supplierGoods);

    int delSupplierGoods(SupplierGoods supplierGoods);

    List<Map<String,Object>> querySupplierGoods(SupplierGoods supplierGoods);
}