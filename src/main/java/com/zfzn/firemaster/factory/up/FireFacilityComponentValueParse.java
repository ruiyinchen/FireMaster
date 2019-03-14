package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.FireFacilityComponentValue;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 消防设施部件模拟值解析
 *
 * @author : Tony.fuxudong
 * Created in 18:39 2019/2/28
 */
public class FireFacilityComponentValueParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {

        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 系统类型
            int systemType = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 系统地址
            int systemAddr = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 部件类型
            int partType = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 部件地址
            int addrCode = 0;
            int partArea = 0;
            int partPlace = 0;
            {
                // 位号
                String low = buf.readBytes(2).toString(UTF_8);
                String high = buf.readBytes(2).toString(UTF_8);
                partPlace = Integer.parseInt(high + low, 16);
                // 区号
                String low1 = buf.readBytes(2).toString(UTF_8);
                String high1 = buf.readBytes(2).toString(UTF_8);
                partArea = Integer.parseInt(high1 + low1, 16);

                addrCode = Integer.parseInt(high1 + low1 + high + low, 16);
            }
            // 模拟量类型
            int valueType = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 模拟值
            int value = 0;
            {
                String low = buf.readBytes(2).toString(UTF_8);
                String high = buf.readBytes(2).toString(UTF_8);
                value = Integer.parseInt(high + low, 16);
            }
            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            FireFacilityComponentValue infoObj = new FireFacilityComponentValue(systemType, systemAddr, partType, partArea, partPlace, addrCode, valueType, value, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
