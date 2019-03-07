package com.zfzn.firemaster.domain.down;

/**
 * 初始化用户信息传输装置
 *
 * @author : Tony.fuxudong
 * Created in 15:43 2019/3/7
 */
public class CheckCommand extends CommandItem {
    /**
     * 超时时间（单位：分钟）
     */
    private int overtime;

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }
}
