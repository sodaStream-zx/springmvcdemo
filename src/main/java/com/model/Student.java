package com.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author 一杯咖啡
 */
public class Student {
    private Integer sid;
    @NotNull
    private String sname;
    @Max(10)
    private Integer sage;

    public Student() {
    }

    public Student(Integer sid, String sname, Integer sage) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }
}
