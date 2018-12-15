package com.zking.erp.statistics.model;

import java.io.Serializable;

public class EmpRole implements Serializable {
    private String userid;

    private String roleid;

    public EmpRole(String userid, String roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }

    public EmpRole() {
        super();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }
}