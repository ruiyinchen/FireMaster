package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 建筑消防设施软件版本
 *
 * @author : Tony.fuxudong
 * Created in 9:36 2019/3/1
 */
public class FireFacilitySoftwareVersion {
    /**
     * 系统类型
     */
    private int systemType;
    /**
     * 系统地址
     */
    private int systemAddr;
    /**
     * 主版本号
     */
    private int majorVersionNo;
    /**
     * 次版本号
     */
    private int minorVersionNo;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public FireFacilitySoftwareVersion(int systemType, int systemAddr, int majorVersionNo, int minorVersionNo, Date triggerTime) {
        this.systemType = systemType;
        this.systemAddr = systemAddr;
        this.majorVersionNo = majorVersionNo;
        this.minorVersionNo = minorVersionNo;
        this.triggerTime = triggerTime;
    }

    public FireFacilitySoftwareVersion() {
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

    public int getMajorVersionNo() {
        return majorVersionNo;
    }

    public void setMajorVersionNo(int majorVersionNo) {
        this.majorVersionNo = majorVersionNo;
    }

    public int getMinorVersionNo() {
        return minorVersionNo;
    }

    public void setMinorVersionNo(int minorVersionNo) {
        this.minorVersionNo = minorVersionNo;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}