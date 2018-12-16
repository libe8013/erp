package com.zking.erp.basic.service.Impl;

import com.zking.erp.basic.mapper.GoodsTypeMapper;
import com.zking.erp.basic.model.GoodsType;
import com.zking.erp.basic.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public int deleteByPrimaryKey(String uuid) {
        return goodsTypeMapper.deleteByPrimaryKey(uuid);
    }

    @Override
    public int insert(GoodsType record) {
        return goodsTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(GoodsType record) {
        return goodsTypeMapper.insertSelective(record);
    }

    @Override
    public GoodsType selectByPrimaryKey(String uuid) {
        return goodsTypeMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsType record) {
        return goodsTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GoodsType record) {
        return goodsTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GoodsType> queryGoodsType(GoodsType goodsType) {
        return goodsTypeMapper.queryGoodsType(goodsType);
    }
}
