package com.zking.erp.basic.service;

import com.zking.erp.base.util.PageBean;
import com.zking.erp.basic.model.Goods;

import java.util.List;

public interface IGoodsService {
    int deleteByPrimaryKey(String uuid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> queryGoodsLikePager(Goods goods, PageBean pageBean);
}