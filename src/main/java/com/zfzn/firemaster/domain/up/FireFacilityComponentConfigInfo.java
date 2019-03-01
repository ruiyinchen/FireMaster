package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 建筑消防设施系统部件配置情况
 *
 * @author : Tony.fuxudong
 * Created in 10:03 2019/3/1
 */
public class FireFacilityComponentConfigInfo {
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
     * 部件说明
     */
    private String legend;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public FireFacilityComponentConfigInfo(int systemType, int systemAddr, int partType, int partArea, int partPlace, String legend, Date triggerTime) {
        this.systemType = systemType;
        this.systemAddr = systemAddr;
        this.partType = partType;
        this.partArea = partArea;
        this.partPlace = partPlace;
        this.legend = legend;
        this.triggerTime = triggerTime;
    }

    public FireFacilityComponentConfigInfo() {
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

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}