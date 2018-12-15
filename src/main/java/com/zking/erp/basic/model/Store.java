package com.zking.erp.basic.model;

import java.io.Serializable;

public class Store implements Serializable {
    private String uuid;

    private String name;

    private Integer empuuid;

    public Store(String uuid, String name, Integer empuuid) {
        this.uuid = uuid;
        this.name = name;
        this.empuuid = empuuid;
    }

    public Store() {
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

    public Integer getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(Integer empuuid) {
        this.empuuid = empuuid;
    }
}