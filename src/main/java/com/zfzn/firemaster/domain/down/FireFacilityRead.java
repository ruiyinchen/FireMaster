package com.zfzn.firemaster.domain.down;

/**
 * 读设施
 *
 * @author : Tony.fuxudong
 * Created in 15:26 2019/3/7
 */
public class FireFacilityRead extends CommandItem{
    /**
     * 系统类型
     */
    private int systemType;
    /**
     *系统地址
     */
    private int systemAddr;

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
}
