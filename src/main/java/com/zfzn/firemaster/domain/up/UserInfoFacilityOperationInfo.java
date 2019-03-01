package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 用户信息传输装置操作信息
 *
 * @author : Tony.fuxudong
 * Created in 14:40 2019/3/1
 */
public class UserInfoFacilityOperationInfo {
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

    public UserInfoFacilityOperationInfo(byte[] operationalSign, int operatorNo, Date triggerTime) {
        this.operationalSign = operationalSign;
        this.operatorNo = operatorNo;
        this.triggerTime = triggerTime;
    }

    public UserInfoFacilityOperationInfo() {
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
