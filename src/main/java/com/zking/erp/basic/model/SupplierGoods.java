package com.zking.erp.basic.model;

import java.io.Serializable;

public class SupplierGoods implements Serializable{
    private String goodsuuid;

    private String supplieruuid;

    public SupplierGoods(String goodsuuid, String supplieruuid) {
        this.goodsuuid = goodsuuid;
        this.supplieruuid = supplieruuid;
    }

    public SupplierGoods() {
        super();
    }

    public String getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(String goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public String getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(String supplieruuid) {
        this.supplieruuid = supplieruuid;
    }
}