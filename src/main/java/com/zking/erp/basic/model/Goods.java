package com.zking.erp.basic.model;

import java.io.Serializable;

public class Goods implements Serializable {
    private String uuid;

    private String name;

    private String origin;

    private String producer;

    private String unit;

    private Float inprice;

    private Float outprice;

    private String goodstypeuuid;

    public Goods(String uuid, String name, String origin, String producer, String unit, Float inprice, Float outprice, String goodstypeuuid) {
        this.uuid = uuid;
        this.name = name;
        this.origin = origin;
        this.producer = producer;
        this.unit = unit;
        this.inprice = inprice;
        this.outprice = outprice;
        this.goodstypeuuid = goodstypeuuid;
    }

    public Goods() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getInprice() {
        return inprice;
    }

    public void setInprice(Float inprice) {
        this.inprice = inprice;
    }

    public Float getOutprice() {
        return outprice;
    }

    public void setOutprice(Float outprice) {
        this.outprice = outprice;
    }

    public String getGoodstypeuuid() {
        return goodstypeuuid;
    }

    public void setGoodstypeuuid(String goodstypeuuid) {
        this.goodstypeuuid = goodstypeuuid;
    }
}