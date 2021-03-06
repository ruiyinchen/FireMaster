package com.zfzn.firemaster.cache;

import java.io.Serializable;

/**
 * 客户端全局量
 *
 * @author : Tony.fuxudong
 * Created in 17:11 2019/3/6
 */
public class GlobalValue implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 5205098000820469776L;

    /**
     * 协议版本号--主版本号
     */
    private int mainVersionNo;
    /**
     * 协议版本号--用户版本号
     */
    private int userVersionNo;
    /**
     * 监控中心地址
     */
    private byte[] monitorCenterAddr;
    /**
     * 用户信息传输装置地址
     */
    private byte[] transmissionDeviceAddr;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getMainVersionNo() {
        return mainVersionNo;
    }

    public void setMainVersionNo(int mainVersionNo) {
        this.mainVersionNo = mainVersionNo;
    }

    public int getUserVersionNo() {
        return userVersionNo;
    }

    public void setUserVersionNo(int userVersionNo) {
        this.userVersionNo = userVersionNo;
    }

    public byte[] getMonitorCenterAddr() {
        return monitorCenterAddr;
    }

    public void setMonitorCenterAddr(byte[] monitorCenterAddr) {
        this.monitorCenterAddr = monitorCenterAddr;
    }

    public byte[] getTransmissionDeviceAddr() {
        return transmissionDeviceAddr;
    }

    public void setTransmissionDeviceAddr(byte[] transmissionDeviceAddr) {
        this.transmissionDeviceAddr = transmissionDeviceAddr;
    }
}
