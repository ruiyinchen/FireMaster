package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 建筑消防设施部件状态
 *
 * @author : Tony.fuxudong
 * Created in 17:16 2019/2/28
 */
public class FireFacilityComponentStatus {
    /**
     * 系统类型
     */
    private int systemType;
    /**
     * 系统地址
     */
    private int systemAddr;
    /**
     * 部件类型
     */
    private int partType;
    /**
     * 部件地址(区号)
     */
    private int partArea;
    /**
     * 部件地址(位号)
     */
    private int partPlace;
    /**
     * 部件状态
     */
    private byte[] status;
    /**
     * 部件说明
     */
    private String partLegend;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public FireFacilityComponentStatus(int systemType, int systemAddr, int partType, int partArea, int partPlace, byte[] status, String partLegend, Date triggerTime) {
        this.systemType = systemType;
        this.systemAddr = systemAddr;
        this.partType = partType;
        this.partArea = partArea;
        this.partPlace = partPlace;
        this.status = status;
        this.partLegend = partLegend;
        this.triggerTime = triggerTime;
    }

    public FireFacilityComponentStatus() {
    }

    public int getSystemType() {
        return systemType;
    }

    public void setSystemType(int systemType) {
        this.systemType = systemType;
    }

    public int getSystemAddr() {
        return systemAddr;
    }

    public void setSystemAddr(int systemAddr) {
        this.systemAddr = systemAddr;
    }

    public int getPartType() {
        return partType;
    }

    public void setPartType(int partType) {
        this.partType = partType;
    }

    public int getPartArea() {
        return partArea;
    }

    public void setPartArea(int partArea) {
        this.partArea = partArea;
    }

    public int getPartPlace() {
        return partPlace;
    }

    public void setPartPlace(int partPlace) {
        this.partPlace = partPlace;
    }

    public byte[] getStatus() {
        return status;
    }

    public void setStatus(byte[] status) {
        this.status = status;
    }

    public String getPartLegend() {
        return partLegend;
    }

    public void setPartLegend(String partLegend) {
        this.partLegend = partLegend;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}