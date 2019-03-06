package com.zfzn.firemaster.cache;

import com.zfzn.firemaster.domain.TcpDataPack;

/**
 * GlobalValue 适配器
 *
 * @author : Tony.fuxudong
 * Created in 18:37 2019/3/6
 */
public class GlobalValueAdapter {
    private TcpDataPack tcpDataPack;

    public GlobalValueAdapter(TcpDataPack tcpDataPack) {
        this.tcpDataPack = tcpDataPack;
    }

    public GlobalValue value(){
        GlobalValue value=new GlobalValue();
        value.setMainVersionNo(tcpDataPack.getMainVersionNo());
        value.setUserVersionNo(tcpDataPack.getUserVersionNo());
        value.setMonitorCenterAddr(tcpDataPack.getTargetAddress());
        value.setTransmissionDeviceAddr(tcpDataPack.getSourceAddress());
        return value;
    }
}
