package com.zfzn.firemaster.domain.up;

/**
 * 部件共有属性
 *
 * @author : Tony.fuxudong
 * Created in 19:50 2019/3/13
 */
public abstract class FireFacilityComponent {
    /**
     * 系统类型
     */
    private int systemType;
    /**
     * 系统地址
     */
    private int systemAddr;
    /**
     * 部件类型
     */
    private int partType;
    /**
     * 部件地址(区号)
     */
    private int partArea;
    /**
     * 部件地址(位号)
     */
    private int partPlace;
    /**
     * 部件地址码
     */
    private int addrCode;

    public FireFacilityComponent(int systemType, int systemAddr, int partType, int partArea, int partPlace, int addrCode) {
        this.systemType = systemType;
        this.systemAddr = systemAddr;
        this.partType = partType;
        this.partArea = partArea;
        this.partPlace = partPlace;
        this.addrCode = addrCode;
    }

    public FireFacilityComponent() {
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

    public int getPartType() {
        return partType;
    }

    public void setPartType(int partType) {
        this.partType = partType;
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

    public int getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(int addrCode) {
        this.addrCode = addrCode;
    }
}
