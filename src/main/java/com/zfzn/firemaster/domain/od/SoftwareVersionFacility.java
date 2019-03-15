package com.zfzn.firemaster.domain.od;

import java.util.Date;

public class SoftwareVersionFacility {
    private Long id;

    private Integer sysType;

    private Integer sysAddr;

    private Integer mainVersion;

    private Integer minorVersion;

    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSysType() {
        return sysType;
    }

    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    public Integer getSysAddr() {
        return sysAddr;
    }

    public void setSysAddr(Integer sysAddr) {
        this.sysAddr = sysAddr;
    }

    public Integer getMainVersion() {
        return mainVersion;
    }

    public void setMainVersion(Integer mainVersion) {
        this.mainVersion = mainVersion;
    }

    public Integer getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(Integer minorVersion) {
        this.minorVersion = minorVersion;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}