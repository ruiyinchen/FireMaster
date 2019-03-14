package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 建筑消防设施部件状态
 *
 * @author : Tony.fuxudong
 * Created in 17:16 2019/2/28
 */
public class FireFacilityComponentStatus extends FireFacilityComponent{
    /**
     * 部件状态
     */
    private byte[] status;
    /**
     * 部件说明
     */
    private String partLegend;
    /**
     * 触发时间
     */
    private Date triggerTime;

    public FireFacilityComponentStatus(int systemType, int systemAddr, int partType, int partArea, int partPlace, int addrCode, byte[] status, String partLegend, Date triggerTime) {
        super(systemType, systemAddr, partType, partArea, partPlace, addrCode);
        this.status = status;
        this.partLegend = partLegend;
        this.triggerTime = triggerTime;
    }

    public FireFacilityComponentStatus() {
    }

    public byte[] getStatus() {
        return status;
    }

    public void setStatus(byte[] status) {
        this.status = status;
    }

    public String getPartLegend() {
        return partLegend;
    }

    public void setPartLegend(String partLegend) {
        this.partLegend = partLegend;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}