package com.zking.erp.stock.vo;

import com.zking.erp.basic.model.Goods;
import com.zking.erp.basic.model.Store;
import com.zking.erp.personnel.model.Emp;
import com.zking.erp.stock.model.StoreDetail;
import com.zking.erp.stock.model.StoreOper;

public class StoreOperVo extends StoreOper {
    private Goods goods;
    private Store store;
    private Emp emp;
    private StoreDetail storeDetail;

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

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public StoreDetail getStoreDetail() {
        return storeDetail;
    }

    public void setStoreDetail(StoreDetail storeDetail) {
        this.storeDetail = storeDetail;
    }
}
