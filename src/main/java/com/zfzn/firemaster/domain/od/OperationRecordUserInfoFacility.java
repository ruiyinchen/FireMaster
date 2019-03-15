package com.zfzn.firemaster.domain.od;

import java.util.Date;

public class OperationRecordUserInfoFacility {
    private Long id;

    private Byte reset;

    private Byte silence;

    private Byte manualAlarm;

    private Byte eliminateAlarm;

    private Byte selfTest;

    private Byte confirm;

    private Byte test;

    private Byte reserved;

    private Integer operator;

    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getReset() {
        return reset;
    }

    public void setReset(Byte reset) {
        this.reset = reset;
    }

    public Byte getSilence() {
        return silence;
    }

    public void setSilence(Byte silence) {
        this.silence = silence;
    }

    public Byte getManualAlarm() {
        return manualAlarm;
    }

    public void setManualAlarm(Byte manualAlarm) {
        this.manualAlarm = manualAlarm;
    }

    public Byte getEliminateAlarm() {
        return eliminateAlarm;
    }

    public void setEliminateAlarm(Byte eliminateAlarm) {
        this.eliminateAlarm = eliminateAlarm;
    }

    public Byte getSelfTest() {
        return selfTest;
    }

    public void setSelfTest(Byte selfTest) {
        this.selfTest = selfTest;
    }

    public Byte getConfirm() {
        return confirm;
    }

    public void setConfirm(Byte confirm) {
        this.confirm = confirm;
    }

    public Byte getTest() {
        return test;
    }

    public void setTest(Byte test) {
        this.test = test;
    }

    public Byte getReserved() {
        return reserved;
    }

    public void setReserved(Byte reserved) {
        this.reserved = reserved;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}