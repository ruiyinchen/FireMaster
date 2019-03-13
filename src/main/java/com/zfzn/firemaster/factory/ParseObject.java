package com.zfzn.firemaster.factory;

import io.netty.buffer.ByteBuf;

import java.util.List;

/**
 * 信息对象解析接口
 *
 * @author : Tony.fuxudong
 * Created in 14:26 2019/2/28
 */
public interface ParseObject {
    /**
     * 解析处理方法
     * @param buf
     * @return
     */
    List<Object> analyze(ByteBuf buf, int  objNum);
}
