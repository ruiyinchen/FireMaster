package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 消防设施部件模拟值
 *
 * @author : Tony.fuxudong
 * Created in 18:39 2019/2/28
 */
public class FireFacilityComponentValue {
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
     * 模拟量值类型
     */
    private int valueType;
    /**
     * 模拟量值
     */
    private int value;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public FireFacilityComponentValue(int systemType, int systemAddr, int partType, int partArea, int partPlace, int valueType, int value, Date triggerTime) {
        this.systemType = systemType;
        this.systemAddr = systemAddr;
        this.partType = partType;
        this.partArea = partArea;
        this.partPlace = partPlace;
        this.valueType = valueType;
        this.value = value;
        this.triggerTime = triggerTime;
    }

    public FireFacilityComponentValue() {
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

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valueType) {
        this.valueType = valueType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}
