package com.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author 一杯咖啡
 */
public class Admin {
    private Integer aid;
    @NotNull
    private String aname;
    @NotNull
    private String apwd;
    @Max(10)
    private Integer aauthority;


    public Admin(Integer aid, String aname, String apwd, Integer aauthority) {
        this.aid = aid;
        this.aname = aname;
        this.apwd = apwd;
        this.aauthority = aauthority;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", apwd='" + apwd + '\'' +
                ", aauthority=" + aauthority +
                '}';
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public Integer getAauthority() {
        return aauthority;
    }

    public void setAauthority(Integer aauthority) {
        this.aauthority = aauthority;
    }
}
