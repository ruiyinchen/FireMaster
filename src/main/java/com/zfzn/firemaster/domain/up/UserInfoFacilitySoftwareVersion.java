package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 用户信息传输装置软件版本
 *
 * @author : Tony.fuxudong
 * Created in 14:56 2019/3/1
 */
public class UserInfoFacilitySoftwareVersion {
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

    public UserInfoFacilitySoftwareVersion(int majorVersionNo, int minorVersionNo, Date triggerTime) {
        this.majorVersionNo = majorVersionNo;
        this.minorVersionNo = minorVersionNo;
        this.triggerTime = triggerTime;
    }

    public UserInfoFacilitySoftwareVersion() {
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
