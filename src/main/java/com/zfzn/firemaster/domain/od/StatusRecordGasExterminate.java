package com.zfzn.firemaster.domain.od;

import java.util.Date;

public class StatusRecordGasExterminate {
    private Long id;

    private Integer sysType;

    private Integer sysAddr;

    private Integer areaAddr;

    private Integer alarmType;

    private Byte alarmValue;

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

    public Integer getAreaAddr() {
        return areaAddr;
    }

    public void setAreaAddr(Integer areaAddr) {
        this.areaAddr = areaAddr;
    }

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public Byte getAlarmValue() {
        return alarmValue;
    }

    public void setAlarmValue(Byte alarmValue) {
        this.alarmValue = alarmValue;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}