package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 建筑消防设施系统配置信息
 *
 * @author : Tony.fuxudong
 * Created in 9:51 2019/3/1
 */
public class FireFacilitySystemConfigInfo {
    /**
     * 系统类型
     */
    private int systemType;
    /**
     * 系统地址
     */
    private int systemAddr;
    /**
     * 系统说明长度
     */
    private int legendLength;
    /**
     * 系统说明
     */
    private String legend;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public FireFacilitySystemConfigInfo(int systemType, int systemAddr, int legendLength, String legend, Date triggerTime) {
        this.systemType = systemType;
        this.systemAddr = systemAddr;
        this.legendLength = legendLength;
        this.legend = legend;
        this.triggerTime = triggerTime;
    }

    public FireFacilitySystemConfigInfo() {
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

    public int getLegendLength() {
        return legendLength;
    }

    public void setLegendLength(int legendLength) {
        this.legendLength = legendLength;
    }

    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}
