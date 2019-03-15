package com.zfzn.firemaster.domain.od;

public class ConfFacilitySys {
    private Long id;

    private Integer sysType;

    private Integer sysAddr;

    private String sysDescription;

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

    public String getSysDescription() {
        return sysDescription;
    }

    public void setSysDescription(String sysDescription) {
        this.sysDescription = sysDescription == null ? null : sysDescription.trim();
    }
}