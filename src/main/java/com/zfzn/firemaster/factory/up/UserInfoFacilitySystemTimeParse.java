package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 用户信息传输装置系统时间解析
 *
 * @author : Tony.fuxudong
 * Created in 15:10 2019/3/1
 */
public class UserInfoFacilitySystemTimeParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {

            // 状态发生时间
            Date systemTime = DateUtils.bufToDate(buf);

            list.add(systemTime);
        }
        return list;
    }
}
