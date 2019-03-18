package com.zfzn.firemaster.domain.bo;

/**
 * 推送警报对象
 *
 * @author : Tony.fuxudong
 * Created in 9:01 2019/3/18
 */
public class AlarmObject {
    private int pushType;
    private Object obj;

    public AlarmObject(int pushType, Object obj) {
        this.pushType = pushType;
        this.obj = obj;
    }

    public AlarmObject() {
    }

    public int getPushType() {
        return pushType;
    }

    public void setPushType(int pushType) {
        this.pushType = pushType;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
