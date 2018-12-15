package com.zking.erp.purchase.model;

import java.io.Serializable;
import java.util.Date;

public class ReturnOrdersDetail implements Serializable {
    private String uuid;

    private Integer goodsuuid;

    private String goodsname;

    private Float price;

    private Integer num;

    private Float money;

    private Date endtime;

    private Integer ender;

    private Integer storeuuid;

    private String state;

    private Integer ordersuuid;

    public ReturnOrdersDetail(String uuid, Integer goodsuuid, String goodsname, Float price, Integer num, Float money, Date endtime, Integer ender, Integer storeuuid, String state, Integer ordersuuid) {
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

    public ReturnOrdersDetail() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(Integer goodsuuid) {
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

    public Integer getEnder() {
        return ender;
    }

    public void setEnder(Integer ender) {
        this.ender = ender;
    }

    public Integer getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Integer storeuuid) {
        this.storeuuid = storeuuid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getOrdersuuid() {
        return ordersuuid;
    }

    public void setOrdersuuid(Integer ordersuuid) {
        this.ordersuuid = ordersuuid;
    }
}