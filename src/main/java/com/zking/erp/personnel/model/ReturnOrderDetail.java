package com.zking.erp.personnel.model;

import java.io.Serializable;
import java.util.Date;

public class ReturnOrderDetail implements Serializable {
    private String uuid;

    private String goodsuuid;

    private String goodsname;

    private Float price;

    private Integer num;

    private Float money;

    private Date endtime;

    private String ender;

    private String storeuuid;

    private String state;

    private String ordersuuid;

    public ReturnOrderDetail(String uuid, String goodsuuid, String goodsname, Float price, Integer num, Float money, Date endtime, String ender, String storeuuid, String state, String ordersuuid) {
        this.uuid = uuid;
        this.goodsuuid = goodsuuid;
        this.goodsname = goodsname;
        this.price = price;
        this.num = num;
        this.money = money;
        this.endtime = endtime;
        this.ender = ender;
        this.storeuuid = storeuuid;
        this.state = state;
        this.ordersuuid = ordersuuid;
    }

    public ReturnOrderDetail() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(String goodsuuid) {
        this.goodsuuid = goodsuuid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getEnder() {
        return ender;
    }

    public void setEnder(String ender) {
        this.ender = ender;
    }

    public String getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(String storeuuid) {
        this.storeuuid = storeuuid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrdersuuid() {
        return ordersuuid;
    }

    public void setOrdersuuid(String ordersuuid) {
        this.ordersuuid = ordersuuid;
    }
}