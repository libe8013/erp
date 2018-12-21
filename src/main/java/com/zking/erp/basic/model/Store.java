package com.zking.erp.basic.model;

import java.io.Serializable;

public class Store implements Serializable {
    private String uuid;

    private String name;

    private String empuuid;

    private String  address;

    public Store(String uuid, String name, String empuuid,String address) {
        this.uuid = uuid;
        this.name = name;
        this.empuuid = empuuid;
        this.address=address;
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

    public String getEmpuuid() {
        return empuuid;
    }

    public void setEmpuuid(String empuuid) {
        this.empuuid = empuuid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}