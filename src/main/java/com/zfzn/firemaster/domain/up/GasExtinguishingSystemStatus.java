package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 上传气体灭火系统状态信息
 *
 * @author : Tony.fuxudong
 * Created in 11:49 2019/3/5
 */
public class GasExtinguishingSystemStatus {
    /**
     * 系统类型
     */
    private int systemType;
    /**
     * 系统地址
     */
    private int systemAddr;
    /**
     * 分区地址
     */
    private int partAddr;
    /**
     * 系统状态报警类型
     */
    private int alarmType;
    /**
     * 报警恢复
     */
    private int alarmRecovery;
    /**
     * 预留
     */
    private int reserved;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public GasExtinguishingSystemStatus(int systemType, int systemAddr, int partAddr, int alarmType, int alarmRecovery, Date triggerTime) {
        this.systemType = systemType;
        this.systemAddr = systemAddr;
        this.partAddr = partAddr;
        this.alarmType = alarmType;
        this.alarmRecovery = alarmRecovery;
        this.triggerTime = triggerTime;
    }

    public GasExtinguishingSystemStatus() {
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

    public int getPartAddr() {
        return partAddr;
    }

    public void setPartAddr(int partAddr) {
        this.partAddr = partAddr;
    }

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
        this.alarmType = alarmType;
    }

    public int getAlarmRecovery() {
        return alarmRecovery;
    }

    public void setAlarmRecovery(int alarmRecovery) {
        this.alarmRecovery = alarmRecovery;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}