package com.zfzn.firemaster.domain.od;

import java.util.Date;

public class StatusRecordSystem {
    private Long id;

    private Integer sysCode;

    private Integer sysType;

    private Byte normalRun;

    private Byte fireAlarm;

    private Byte breakdown;

    private Byte shield;

    private Byte supervision;

    private Byte started;

    private Byte feedback;

    private Byte delay;

    private Byte mainPowerFailure;

    private Byte backupPowerFailure;

    private Byte busFailure;

    private Byte manualStatus;

    private Byte deployChange;

    private Byte reset;

    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSysCode() {
        return sysCode;
    }

    public void setSysCode(Integer sysCode) {
        this.sysCode = sysCode;
    }

    public Integer getSysType() {
        return sysType;
    }

    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    public Byte getNormalRun() {
        return normalRun;
    }

    public void setNormalRun(Byte normalRun) {
        this.normalRun = normalRun;
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

    public Byte getShield() {
        return shield;
    }

    public void setShield(Byte shield) {
        this.shield = shield;
    }

    public Byte getSupervision() {
        return supervision;
    }

    public void setSupervision(Byte supervision) {
        this.supervision = supervision;
    }

    public Byte getStarted() {
        return started;
    }

    public void setStarted(Byte started) {
        this.started = started;
    }

    public Byte getFeedback() {
        return feedback;
    }

    public void setFeedback(Byte feedback) {
        this.feedback = feedback;
    }

    public Byte getDelay() {
        return delay;
    }

    public void setDelay(Byte delay) {
        this.delay = delay;
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

    public Byte getBusFailure() {
        return busFailure;
    }

    public void setBusFailure(Byte busFailure) {
        this.busFailure = busFailure;
    }

    public Byte getManualStatus() {
        return manualStatus;
    }

    public void setManualStatus(Byte manualStatus) {
        this.manualStatus = manualStatus;
    }

    public Byte getDeployChange() {
        return deployChange;
    }

    public void setDeployChange(Byte deployChange) {
        this.deployChange = deployChange;
    }

    public Byte getReset() {
        return reset;
    }

    public void setReset(Byte reset) {
        this.reset = reset;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}