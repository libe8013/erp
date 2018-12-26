package com.zking.erp.basic.vo;

import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.SupplierGoods;

import java.io.Serializable;

public class SupplierGoodsVo extends SupplierGoods implements Serializable{
    private Goods goods;


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}