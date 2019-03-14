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
    private byte[] original;
    // 2B 起始符
    private byte[] beginSign;
    // 2B 流水号
    private int serialNumber;
    // 1B 主版本号
    private short mainVersionNo;
    // 1B 用户版本号
    private short userVersionNo;
    // 6B 时间标签
    private Date time;
    // 6B 源地址
    private byte[] sourceAddress;
    // 6B 目标地址
    private byte[] targetAddress;
    // 2B 应用数据长度
    private int dataLength;
    // 1B 命令
    private short command;
    // *B<=1024B 应用数据单元
    private ByteBuf data;
    // 1B 校验和
    private short checksum;
    // 2B 结束符
    private byte[] endSign;

    public byte[] getOriginal() {
        return original;
    }

    public void setOriginal(byte[] original) {
        this.original = original;
    }

    public byte[] getBeginSign() {
        return beginSign;
    }

    public void setBeginSign(byte[] beginSign) {
        this.beginSign = beginSign;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public short getMainVersionNo() {
        return mainVersionNo;
    }

    public void setMainVersionNo(short mainVersionNo) {
        this.mainVersionNo = mainVersionNo;
    }

    public short getUserVersionNo() {
        return userVersionNo;
    }

    public void setUserVersionNo(short userVersionNo) {
        this.userVersionNo = userVersionNo;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public byte[] getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(byte[] sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public byte[] getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(byte[] targetAddress) {
        this.targetAddress = targetAddress;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    public short getCommand() {
        return command;
    }

    public void setCommand(short command) {
        this.command = command;
    }

    public ByteBuf getData() {
        return data;
    }

    public void setData(ByteBuf data) {
        this.data = data;
    }

    public short getChecksum() {
        return checksum;
    }

    public void setChecksum(short checksum) {
        this.checksum = checksum;
    }

    public byte[] getEndSign() {
        return endSign;
    }

    public void setEndSign(byte[] endSign) {
        this.endSign = endSign;
    }
}
