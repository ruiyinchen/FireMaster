package com.zfzn.firemaster.domain;

import io.netty.buffer.ByteBuf;

import java.util.Date;

/**
 * TCP 数据包
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-09 19:38
 */
public class TcpDataPack {
    private String original;
    // 2B 起始符
    private String beginSign;
    // 2B 流水号
    private String serialNumber;
    // 1B 主版本号
    private int mainVersionNo;
    // 1B 用户版本号
    private int userVersionNo;
    // 6B 时间标签
    private Date time;
    // 6B 源地址
    private String sourceAddress;
    // 6B 目标地址
    private String targetAddress;
    // 2B 应用数据长度
    private int dataLength;
    // 1B 命令
    private int command;
    // *B<=1024B 应用数据单元
    private ByteBuf data;
    // 1B 校验和
    private String checksum;
    // 2B 结束符
    private String endSign;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getBeginSign() {
        return beginSign;
    }

    public void setBeginSign(String beginSign) {
        this.beginSign = beginSign;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getMainVersionNo() {
        return mainVersionNo;
    }

    public void setMainVersionNo(int mainVersionNo) {
        this.mainVersionNo = mainVersionNo;
    }

    public int getUserVersionNo() {
        return userVersionNo;
    }

    public void setUserVersionNo(int userVersionNo) {
        this.userVersionNo = userVersionNo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public ByteBuf getData() {
        return data;
    }

    public void setData(ByteBuf data) {
        this.data = data;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getEndSign() {
        return endSign;
    }

    public void setEndSign(String endSign) {
        this.endSign = endSign;
    }
}
