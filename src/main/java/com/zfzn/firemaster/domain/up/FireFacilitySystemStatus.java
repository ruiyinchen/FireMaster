package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 建筑消防设施系统状态
 *
 * @author : Tony.fuxudong
 * Created in 16:54 2019/2/28
 */
public class FireFacilitySystemStatus {
    /**
     * 系统类型
     */
    private int systemType;
    /**
     * 系统地址
     */
    private int systemAddr;
    /**
     * 系统状态
     */
    private byte[] status;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public FireFacilitySystemStatus(int systemType, int systemAddr, byte[] status, Date triggerTime) {
        this.systemType = systemType;
        this.systemAddr = systemAddr;
        this.status = status;
        this.triggerTime = triggerTime;
    }

    public FireFacilitySystemStatus() {
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

    public byte[] getStatus() {
        return status;
    }

    public void setStatus(byte[] status) {
        this.status = status;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}
