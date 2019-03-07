package com.zfzn.firemaster.domain.down;

/**
 * 初始化用户信息传输装置
 *
 * @author : Tony.fuxudong
 * Created in 15:43 2019/3/7
 */
public class UserInfoFacilityInitializing extends CommandItem {
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
