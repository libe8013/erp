package com.zking.erp.stock.vo;

import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.stock.model.StoreDetail;

public class StoredetailVo extends StoreDetail {
    private Goods goods;
    private Store store;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
