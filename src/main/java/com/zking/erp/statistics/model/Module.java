package com.zking.erp.statistics.model;

import java.io.Serializable;

public class Module implements Serializable{
    private String id;

    private String text;

    private String url;

    private String icon;

    private String sort;

    private String pid;

    public Module(String id, String text, String url, String icon, String sort, String pid) {
        this.id = id;
        this.text = text;
        this.url = url;
        this.icon = icon;
        this.sort = sort;
        this.pid = pid;
    }

    public Module() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}