package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 消防设施部件模拟值
 *
 * @author : Tony.fuxudong
 * Created in 18:39 2019/2/28
 */
public class FireFacilityComponentValue extends FireFacilityComponent{
    /**
     * 值类型
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

    public FireFacilityComponentValue(int systemType, int systemAddr, int partType, int partArea, int partPlace, int addrCode, int valueType, int value, Date triggerTime) {
        super(systemType, systemAddr, partType, partArea, partPlace, addrCode);
        this.valueType = valueType;
        this.value = value;
        this.triggerTime = triggerTime;
    }

    public FireFacilityComponentValue() {
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
