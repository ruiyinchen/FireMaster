package com.zfzn.firemaster.domain.od;

import java.util.Date;

public class StatusRecordUserInfoFacility {
    private Long id;

    private Byte normal;

    private Byte fireAlarm;

    private Byte breakdown;

    private Byte mainPowerFailure;

    private Byte backupPowerFailure;

    private Byte channelFailure;

    private Byte connectionFailure;

    private Byte reserved;

    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getNormal() {
        return normal;
    }

    public void setNormal(Byte normal) {
        this.normal = normal;
    }

    public Byte getFireAlarm() {
        return fireAlarm;
    }

    public void setFireAlarm(Byte fireAlarm) {
        this.fireAlarm = fireAlarm;
    }

    public Byte getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(Byte breakdown) {
        this.breakdown = breakdown;
    }

    public Byte getMainPowerFailure() {
        return mainPowerFailure;
    }

    public void setMainPowerFailure(Byte mainPowerFailure) {
        this.mainPowerFailure = mainPowerFailure;
    }

    public Byte getBackupPowerFailure() {
        return backupPowerFailure;
    }

    public void setBackupPowerFailure(Byte backupPowerFailure) {
        this.backupPowerFailure = backupPowerFailure;
    }

    public Byte getChannelFailure() {
        return channelFailure;
    }

    public void setChannelFailure(Byte channelFailure) {
        this.channelFailure = channelFailure;
    }

    public Byte getConnectionFailure() {
        return connectionFailure;
    }

    public void setConnectionFailure(Byte connectionFailure) {
        this.connectionFailure = connectionFailure;
    }

    public Byte getReserved() {
        return reserved;
    }

    public void setReserved(Byte reserved) {
        this.reserved = reserved;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}