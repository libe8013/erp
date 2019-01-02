package com.zking.erp.log.model;

import java.util.Date;

public class Log {
    private String id;

    private String empid;

    private String ip;

    private String moduleid;

    private Date createdate;

    private String content;

    public Log(String id, String empid, String ip, String moduleid, Date createdate, String content) {
        this.id = id;
        this.empid = empid;
        this.ip = ip;
        this.moduleid = moduleid;
        this.createdate = createdate;
        this.content = content;
    }

    public Log() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}