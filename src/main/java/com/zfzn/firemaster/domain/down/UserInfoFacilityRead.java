package com.zfzn.firemaster.domain.down;

/**
 * 读用户传输装置
 *
 * @author : Tony.fuxudong
 * Created in 15:43 2019/3/7
 */
public class UserInfoFacilityRead extends CommandItem {
    /**
     * 运行状态
     */
    private int reserved;

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }
}
