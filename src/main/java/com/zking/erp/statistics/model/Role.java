package com.zking.erp.statistics.model;

import java.io.Serializable;

public class Role implements Serializable {
    private String id;

    private String rolename;

    private String remark;

    public Role(String id, String rolename, String remark) {
        this.id = id;
        this.rolename = rolename;
        this.remark = remark;
    }

    public Role() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}