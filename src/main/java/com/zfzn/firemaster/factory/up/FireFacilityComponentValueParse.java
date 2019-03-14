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
            int systemType = buf.readUnsignedByte();
            // 系统地址
            int systemAddr = buf.readUnsignedByte();
            // 部件类型
            int partType = buf.readUnsignedByte();

            // 部件地址
            byte[] ac = new byte[4];
            buf.readBytes(ac);
            // 位号
            int partPlace = (ac[1] << 8) & 0xFF | ac[0] & 0xFF;
            // 区号
            int partArea = (ac[3] << 8) & 0xFF | ac[2] & 0xFF;
            // 地址码
            int addrCode = (ac[3] << 24) & 0xFFFFFF | ac[2] << 16 & 0xFFFFFF | (ac[1] << 8) & 0xFFFFFF | ac[0] & 0xFFFFFF;

            // 模拟量类型
            int valueType = buf.readUnsignedByte();

            // 模拟值
            byte[] valueArr=new byte[2];
            buf.readBytes(valueArr);
            int value = (valueArr[1] << 8) & 0xFF | valueArr[0] & 0xFF;

            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            FireFacilityComponentValue infoObj = new FireFacilityComponentValue(systemType, systemAddr, partType, partArea, partPlace, addrCode, valueType, value, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
