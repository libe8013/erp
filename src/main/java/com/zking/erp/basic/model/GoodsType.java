package com.zking.erp.basic.model;

import java.io.Serializable;

public class GoodsType implements Serializable {
    private String uuid;

    private String name;

    private Integer sort;

    public GoodsType(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public GoodsType() {
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}