package com.zking.erp.stock.model;

import java.io.Serializable;
import java.util.Date;

public class Inventory implements Serializable {
    private String uuid;

    private Integer goodsuuid;

    private Integer storeuuid;

    private Integer num;

    private String type;

    private Date createtime;

    private Date checktime;

    private Integer creater;

    private Integer checker;

    private String state;

    private String remark;

    public Inventory(String uuid, Integer goodsuuid, Integer storeuuid, Integer num, String type, Date createtime, Date checktime, Integer creater, Integer checker, String state, String remark) {
        this.uuid = uuid;
        this.goodsuuid = goodsuuid;
        this.storeuuid = storeuuid;
        this.num = num;
        this.type = type;
        this.createtime = createtime;
        this.checktime = checktime;
        this.creater = creater;
        this.checker = checker;
        this.state = state;
        this.remark = remark;
    }

    public Inventory() {
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

    public Integer getStoreuuid() {
        return storeuuid;
    }

    public void setStoreuuid(Integer storeuuid) {
        this.storeuuid = storeuuid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Integer getChecker() {
        return checker;
    }

    public void setChecker(Integer checker) {
        this.checker = checker;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}