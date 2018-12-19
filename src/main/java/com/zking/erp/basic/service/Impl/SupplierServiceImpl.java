package com.zking.erp.basic.service.Impl;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.mapper.SupplierMapper;
import com.zking.erp.basic.model.Supplier;
import com.zking.erp.basic.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return supplierMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(Supplier record) {
        return supplierMapper.insert(record);
    }

    @Override
    public int insertSelective(Supplier record) {
        return supplierMapper.insertSelective(record);
    }

    @Override
    public Supplier selectByPrimaryKey(String uuid) {
        return supplierMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Supplier record) {
        return supplierMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Supplier record) {
        return supplierMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Supplier> querySupplierLikePager(Supplier supplier, PageBean pageBean) {
        return supplierMapper.querySupplierLikePager(supplier);
    }
}
