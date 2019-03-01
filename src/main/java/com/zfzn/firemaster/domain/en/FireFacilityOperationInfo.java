package com.zfzn.firemaster.domain.en;

import java.util.Date;

/**
 * 建筑消防设施操作信息
 *
 * @author : Tony.fuxudong
 * Created in 9:11 2019/3/1
 */
public class FireFacilityOperationInfo{
    /**
     * 系统类型标志
     */
    private int systemType;
    /**
     * 系统地址
     */
    private int systemAddr;
    /**
     * 操作标志
     */
    private byte[] operationalSign;
    /**
     * 操作员编号
     */
    private int operatorNo;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public FireFacilityOperationInfo(int systemType, int systemAddr, byte[] operationalSign, int operatorNo, Date triggerTime) {
        this.systemType = systemType;
        this.systemAddr = systemAddr;
        this.operationalSign = operationalSign;
        this.operatorNo = operatorNo;
        this.triggerTime = triggerTime;
    }

    public FireFacilityOperationInfo() {
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

    public byte[] getOperationalSign() {
        return operationalSign;
    }

    public void setOperationalSign(byte[] operationalSign) {
        this.operationalSign = operationalSign;
    }

    public int getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(int operatorNo) {
        this.operatorNo = operatorNo;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}
