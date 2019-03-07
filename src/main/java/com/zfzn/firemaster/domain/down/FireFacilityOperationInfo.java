package com.zfzn.firemaster.domain.down;

import java.util.Date;

/**
 * 建筑消防设施操作信息记录
 *
 * @author : Tony.fuxudong
 * Created in 15:07 2019/3/7
 */
public class FireFacilityOperationInfo extends CommandItem{
    /**
     * 系统类型
     */
    private int systemType;
    /**
     *系统地址
     */
    private int systemAddr;
    /**
     * 需查询的操作记录数量
     */
    private int recordNum;
    /**
     * 指定记录的起始时间
     */
    private Date startTime;

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

    public int getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(int recordNum) {
        this.recordNum = recordNum;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
