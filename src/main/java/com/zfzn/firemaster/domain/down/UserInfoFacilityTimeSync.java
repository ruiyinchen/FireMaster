package com.zfzn.firemaster.domain.down;

import java.util.Date;

/**
 * 同步用户信息传输装置时间
 *
 * @author : Tony.fuxudong
 * Created in 16:11 2019/3/7
 */
public class UserInfoFacilityTimeSync extends CommandItem{
    /**
     * 中心时间
     */
    private Date centerTime;

    public Date getCenterTime() {
        return centerTime;
    }

    public void setCenterTime(Date centerTime) {
        this.centerTime = centerTime;
    }
}
