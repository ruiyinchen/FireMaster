package com.zfzn.firemaster.domain.od;

import java.util.Date;

public class SwitchSatusUserInfoFacility {
    private Long id;

    private Integer sysAddr;

    private Integer location;

    private Byte normal;

    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSysAddr() {
        return sysAddr;
    }

    public void setSysAddr(Integer sysAddr) {
        this.sysAddr = sysAddr;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Byte getNormal() {
        return normal;
    }

    public void setNormal(Byte normal) {
        this.normal = normal;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}