package com.zking.erp.personnel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ReturnOrders implements Serializable {
    private String uuid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checktime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endtime;

    private String type;

    private String creater;

    private String checker;

    private String ender;

    private String storeuuid;

    private Float totalmoney;

    private String state;

    private String waybillsn;

    private String ordersuuid;

    public ReturnOrders(String uuid, Date createtime, Date checktime, Date endtime, String type, String creater, String checker, String ender, String storeuuid, Float totalmoney, String state, String waybillsn, String ordersuuid) {
        this.uuid = uuid;
        this.createtime = createtime;
        this.checktime = checktime;
        this.endtime = endtime;
        this.type = type;
        this.creater = creater;
        this.checker = checker;
        this.ender = ender;
        this.storeuuid = storeuuid;
        this.totalmoney = totalmoney;
        this.state = state;
        this.waybillsn = waybillsn;
        this.ordersuuid = ordersuuid;
    }

    public ReturnOrders() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getChecktime() {
        return checktime;
    }

    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }

    public String getEnder() {
        return ender;
    }

    public void setEnder(String ender) {
        this.ender = ender;
    }

    public Float getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(Float totalmoney) {
        this.totalmoney = totalmoney;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getWaybillsn() {
        return waybillsn;
    }

    public void setWaybillsn(String waybillsn) {
        this.waybillsn = waybillsn;
    }

    public String getOrdersuuid() {
        return ordersuuid;
    }

    public void setOrdersuuid(String ordersuuid) {
        this.ordersuuid = ordersuuid;
    }

    public String getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(String storeuuid) {
        this.storeuuid = storeuuid;
    }
}