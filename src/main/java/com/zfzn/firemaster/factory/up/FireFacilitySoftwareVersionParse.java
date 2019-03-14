package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.FireFacilitySoftwareVersion;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 建筑消防设施软件版本解析
 *
 * @author : Tony.fuxudong
 * Created in 9:37 2019/3/1
 */
public class FireFacilitySoftwareVersionParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 系统类型
            int systemType = buf.readUnsignedByte();
            // 系统地址
            int systemAddr = buf.readUnsignedByte();
            // 主版本号
            int majorVersionNo = buf.readUnsignedByte();
            // 次版本号
            int minorVersionNo = buf.readUnsignedByte();

            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            FireFacilitySoftwareVersion infoObj = new FireFacilitySoftwareVersion(systemType, systemAddr, majorVersionNo, minorVersionNo, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
