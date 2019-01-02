package com.zking.erp.market.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@ToString

public class OrderDetail implements Serializable{
    private String uuid;

    private String goodsname;

    private Float price;

    private Integer num;

    private Float money;

    private Date endtime;

    private String ender;

    private String storeuuid;

    private String state;

    private String ordersuuid;

    private String goodsuuid;

    private String supplieruuid;

    public OrderDetail(String uuid, String goodsname, Float price, Integer num, Float money, Date endtime, String ender, String storeuuid, String state, String ordersuuid, String goodsuuid) {
        this.uuid = uuid;
        this.goodsname = goodsname;
        this.price = price;
        this.num = num;
        this.money = money;
        this.endtime = endtime;
        this.ender = ender;
        this.storeuuid = storeuuid;
        this.state = state;
        this.ordersuuid = ordersuuid;
        this.goodsuuid = goodsuuid;
    }

    public String getSupplieruuid() {
        return supplieruuid;
    }

    public void setSupplieruuid(String supplieruuid) {
        this.supplieruuid = supplieruuid;
    }

    public OrderDetail() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getGoodsuuid() {
        return goodsuuid;
    }

    public void setGoodsuuid(String goodsuuid) {
        this.goodsuuid = goodsuuid;
    }
}