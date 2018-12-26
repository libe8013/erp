package com.zking.erp.basic.service.Impl;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.mapper.SupplierGoodsMapper;
import com.zking.erp.basic.model.SupplierGoods;
import com.zking.erp.basic.service.ISupplierGoodsService;
import com.zking.erp.basic.vo.SupplierGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SupplierGoodsServiceImpl implements ISupplierGoodsService {

    @Autowired
    private SupplierGoodsMapper supplierGoodsMapper;

    @Override
    public int insert(SupplierGoods record) {
        return supplierGoodsMapper.insert(record);
    }

    @Override
    public int insertSelective(SupplierGoods record) {
        return supplierGoodsMapper.insertSelective(record);
    }

    @Override
    public List<Map<String,Object>> querySupplierGoodsPager(SupplierGoodsVo supplierGoodsvo, PageBean pageBean) {
        return supplierGoodsMapper.querySupplierGoods(supplierGoodsvo);
    }

    @Override
    public int editSupplierGoods(SupplierGoods supplierGoods) {
        return supplierGoodsMapper.editSupplierGoods(supplierGoods);
    }

    @Override
    public int delSupplierGoods(SupplierGoods supplierGoods) {
        return supplierGoodsMapper.delSupplierGoods(supplierGoods);
    }
}
