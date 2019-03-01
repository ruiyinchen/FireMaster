package com.zfzn.firemaster.domain.en;

import java.util.Date;

/**
 * 用户信息传输装置运行状态
 *
 * @author : Tony.fuxudong
 * Created in 11:17 2019/3/1
 */
public class UserInfoFacilityRunStatus {
    /**
     * 状态
     */
    private byte[] status;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public UserInfoFacilityRunStatus(byte[] status, Date triggerTime) {
        this.status = status;
        this.triggerTime = triggerTime;
    }

    public UserInfoFacilityRunStatus() {
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
