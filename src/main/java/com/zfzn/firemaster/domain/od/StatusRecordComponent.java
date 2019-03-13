package com.zfzn.firemaster.domain.od;

import java.util.Date;

public class StatusRecordComponent {
    private Long id;

    private Integer addrCode;

    private Byte normalRun;

    private Byte fireAlarm;

    private Byte breakdown;

    private Byte shield;

    private Byte supervision;

    private Byte started;

    private Byte feedback;

    private Byte delay;

    private Byte electricityFailure;

    private String explanation;

    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(Integer addrCode) {
        this.addrCode = addrCode;
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

    public Byte getElectricityFailure() {
        return electricityFailure;
    }

    public void setElectricityFailure(Byte electricityFailure) {
        this.electricityFailure = electricityFailure;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation == null ? null : explanation.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}