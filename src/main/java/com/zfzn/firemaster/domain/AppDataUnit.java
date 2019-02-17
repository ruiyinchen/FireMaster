package com.zfzn.firemaster.domain;

import java.util.List;

/**
 * 应用数据单元
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-11 15:40
 */
public class AppDataUnit {
    private int dataType;
    private int count;
    private List<Object> list;

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
