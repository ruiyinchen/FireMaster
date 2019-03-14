package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.GasExtinguishingSystemStatus;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 上传气体灭火系统状态信息 解析
 *
 * @author : Tony.fuxudong
 * Created in 11:46 2019/3/5
 */
public class GasExtinguishingSystemStatusParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 系统类型
            int systemType = buf.readUnsignedByte();
            // 系统地址
            int systemAddr = buf.readUnsignedByte();
            // 分区地址
            int partAddr = buf.readUnsignedByte();

            // 系统状态报警类型
            int alarmType = buf.readUnsignedByte();
            // 报警恢复
            int alarmRecovery = buf.readUnsignedByte();

            buf.readBytes(2);

            // 触发时间
            Date triggerTime = DateUtils.bufToDate(buf);

            GasExtinguishingSystemStatus infoObj = new GasExtinguishingSystemStatus(systemType, systemAddr, partAddr, alarmType, alarmRecovery, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
