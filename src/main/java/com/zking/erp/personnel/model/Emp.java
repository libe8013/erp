package com.zking.erp.personnel.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Emp  implements Serializable {
    private String uuid;

    private String username;

    private String pwd;

    private String name;

    private String gender;

    private String email;

    private String tele;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd" )

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthday;

    private String depuuid;

    public Emp(String uuid, String username, String pwd, String name, String gender, String email, String tele, String address, Date birthday, String depuuid) {
        this.uuid = uuid;
        this.username = username;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.tele = tele;
        this.address = address;
        this.birthday = birthday;
        this.depuuid = depuuid;
    }

    public Emp() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDepuuid() {
        return depuuid;
    }

    public void setDepuuid(String depuuid) {
        this.depuuid = depuuid;
    }
}