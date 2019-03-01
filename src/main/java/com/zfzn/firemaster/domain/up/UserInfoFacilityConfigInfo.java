package com.zfzn.firemaster.domain.up;

import java.util.Date;

/**
 * 用户信息传输装置配置情况
 *
 * @author : Tony.fuxudong
 * Created in 15:02 2019/3/1
 */
public class UserInfoFacilityConfigInfo {
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

    public UserInfoFacilityConfigInfo(int legendLength, String legend, Date triggerTime) {
        this.legendLength = legendLength;
        this.legend = legend;
        this.triggerTime = triggerTime;
    }

    public UserInfoFacilityConfigInfo() {
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
