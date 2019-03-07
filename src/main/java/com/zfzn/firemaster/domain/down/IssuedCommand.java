package com.zfzn.firemaster.domain.down;

import com.zfzn.firemaster.cache.GlobalValue;

import java.util.List;

/**
 * 下发指令结构
 *
 * @author : Tony.fuxudong
 * Created in 9:55 2019/3/7
 */
public class IssuedCommand {
    /**
     * 包数据地址信息
     */
    private GlobalValue globalValue;
    /**
     * 类型标志
     */
    private int dataType;
    /**
     * 命令单项
     */
    private List<? extends CommandItem> list;

    public IssuedCommand(GlobalValue globalValue, int dataType, List<? extends CommandItem> list) {
        this.globalValue = globalValue;
        this.dataType = dataType;
        this.list = list;
    }

    public IssuedCommand() {
    }

    public GlobalValue getGlobalValue() {
        return globalValue;
    }

    public void setGlobalValue(GlobalValue globalValue) {
        this.globalValue = globalValue;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getObjNum() {
        return this.list == null ? 0 : this.list.size();
    }

    public List<? extends CommandItem> getList() {
        return list;
    }

    public void setList(List<? extends CommandItem> list) {
        this.list = list;
    }
}
