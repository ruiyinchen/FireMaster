package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 用户传输装置开关量状态
 *
 * @author : Tony.fuxudong
 * Created in 11:48 2019/3/5
 */
public class UserInfoFacilitySwitchStatus {
    /**
     * 系统地址
     */
    private int systemAddr;
    /**
     * 信息对象长度
     */
    private int objLength = 17;

    private int reserved1 = 0;
    private int reserved2 = 0;
    private int reserved3 = 0;

    /**
     * 开关量位置
     */
    private int switchPosition;
    /**
     * 状态，0正常，1动作
     */
    private int status;

    private int reserved4 = 0;
    private int reserved5 = 0;

    /**
     * 触发时间
     */
    private Date triggerTime;

    public UserInfoFacilitySwitchStatus(int systemAddr, int switchPosition, int status, Date triggerTime) {
        this.systemAddr = systemAddr;
        this.switchPosition = switchPosition;
        this.status = status;
        this.triggerTime = triggerTime;
    }

    public UserInfoFacilitySwitchStatus() {
    }

    public int getSystemAddr() {
        return systemAddr;
    }

    public void setSystemAddr(int systemAddr) {
        this.systemAddr = systemAddr;
    }

    public int getObjLength() {
        return objLength;
    }

    public void setObjLength(int objLength) {
        this.objLength = objLength;
    }

    public int getReserved1() {
        return reserved1;
    }

    public void setReserved1(int reserved1) {
        this.reserved1 = reserved1;
    }

    public int getReserved2() {
        return reserved2;
    }

    public void setReserved2(int reserved2) {
        this.reserved2 = reserved2;
    }

    public int getReserved3() {
        return reserved3;
    }

    public void setReserved3(int reserved3) {
        this.reserved3 = reserved3;
    }

    public int getSwitchPosition() {
        return switchPosition;
    }

    public void setSwitchPosition(int switchPosition) {
        this.switchPosition = switchPosition;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getReserved4() {
        return reserved4;
    }

    public void setReserved4(int reserved4) {
        this.reserved4 = reserved4;
    }

    public int getReserved5() {
        return reserved5;
    }

    public void setReserved5(int reserved5) {
        this.reserved5 = reserved5;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}
