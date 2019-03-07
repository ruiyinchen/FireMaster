package com.zfzn.firemaster.domain.down;

/**
 * 读部件
 *
 * @author : Tony.fuxudong
 * Created in 15:27 2019/3/7
 */
public class FireFacilityComponentRead extends CommandItem{
    /**
     * 系统类型
     */
    private int systemType;
    /**
     * 系统地址
     */
    private int systemAddr;
    /**
     * 部件地址(区号)
     */
    private int partArea;
    /**
     * 部件地址(位号)
     */
    private int partPlace;

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

    public int getPartArea() {
        return partArea;
    }

    public void setPartArea(int partArea) {
        this.partArea = partArea;
    }

    public int getPartPlace() {
        return partPlace;
    }

    public void setPartPlace(int partPlace) {
        this.partPlace = partPlace;
    }
}
