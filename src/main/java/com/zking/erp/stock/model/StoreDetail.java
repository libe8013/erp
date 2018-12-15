package com.zking.erp.stock.model;

import java.io.Serializable;

public class StoreDetail implements Serializable {
    private String uuid;

    private String storeuuid;

    private String goodsuuid;

    private Integer num;

    public StoreDetail(String uuid, String storeuuid, String goodsuuid, Integer num) {
        this.uuid = uuid;
        this.storeuuid = storeuuid;
        this.goodsuuid = goodsuuid;
        this.num = num;
    }

    public StoreDetail() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(String storeuuid) {
        this.storeuuid = storeuuid;
    }

    public String getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(String goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}