package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.FireFacilitySystemTime;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 建筑消防设施系统时间解析
 *
 * @author : Tony.fuxudong
 * Created in 15:10 2019/3/1
 */
public class FireFacilitySystemTimeParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 系统类型
            int systemType = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 系统地址
            int systemAddr = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);

            // 状态发生时间
            Date systemTime = DateUtils.bufToDate(buf);

            FireFacilitySystemTime infoObj = new FireFacilitySystemTime(systemType, systemAddr, systemTime);
            list.add(infoObj);
        }
        return list;
    }
}
