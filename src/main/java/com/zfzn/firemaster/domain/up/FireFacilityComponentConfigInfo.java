package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 建筑消防设施系统部件配置情况
 *
 * @author : Tony.fuxudong
 * Created in 10:03 2019/3/1
 */
public class FireFacilityComponentConfigInfo extends FireFacilityComponent{
    /**
     * 部件说明
     */
    private String legend;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public FireFacilityComponentConfigInfo(int systemType, int systemAddr, int partType, int partArea, int partPlace, int addrCode, String legend, Date triggerTime) {
        super(systemType, systemAddr, partType, partArea, partPlace, addrCode);
        this.legend = legend;
        this.triggerTime = triggerTime;
    }

    public FireFacilityComponentConfigInfo() {
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