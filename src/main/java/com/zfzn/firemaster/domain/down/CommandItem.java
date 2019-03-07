package com.zfzn.firemaster.domain.down;

import java.util.Date;

/**
 * 下发指令项结构
 *
 * @author : Tony.fuxudong
 * Created in 9:38 2019/3/7
 */
public abstract class CommandItem {
    /**
     * 触发时间
     */
    protected Date triggerTime;

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }
}
