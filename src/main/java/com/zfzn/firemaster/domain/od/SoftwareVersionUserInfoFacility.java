package com.zfzn.firemaster.domain.od;

import java.util.Date;

public class SoftwareVersionUserInfoFacility {
    private Long id;

    private Integer mainVersion;

    private Integer minorVersion;

    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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