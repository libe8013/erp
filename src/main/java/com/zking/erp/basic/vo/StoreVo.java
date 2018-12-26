package com.zking.erp.basic.vo;

import com.zking.erp.basic.model.Store;

public class StoreVo extends Store {
    private String supplierid;
    private String goodsuuid;

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public String getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(String goodsuuid) {
        this.goodsuuid = goodsuuid;
    }
}
