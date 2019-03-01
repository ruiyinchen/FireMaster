package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 建筑消防设施系统时间
 *
 * @author : Tony.fuxudong
 * Created in 15:08 2019/3/1
 */
public class FireFacilitySystemTime {
    /**
     * 系统类型
     */
    private int systemType;
    /**
     * 系统地址
     */
    private int systemAddr;
    /**
     * 系统时间
     */
    private Date systemTime;

    public FireFacilitySystemTime(int systemType, int systemAddr, Date systemTime) {
        this.systemType = systemType;
        this.systemAddr = systemAddr;
        this.systemTime = systemTime;
    }

    public FireFacilitySystemTime() {
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

    public Date getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Date systemTime) {
        this.systemTime = systemTime;
    }
}
