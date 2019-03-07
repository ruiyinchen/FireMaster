package com.zfzn.firemaster.domain.down;

import java.util.Date;

/**
 * 读用户信息传输装置操作信息记录
 *
 * @author : Tony.fuxudong
 * Created in 15:50 2019/3/7
 */
public class UserInfoFacilityOperationInfo extends CommandItem{
    /**
     * 需查询的操作记录数量
     */
    private int recordNum;
    /**
     * 指定记录的起始时间
     */
    private Date startTime;

    public int getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(int recordNum) {
        this.recordNum = recordNum;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
