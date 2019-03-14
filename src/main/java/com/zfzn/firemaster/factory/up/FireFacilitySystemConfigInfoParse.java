package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.FireFacilitySystemConfigInfo;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 建筑消防设施系统配置信息解析
 *
 * @author : Tony.fuxudong
 * Created in 9:52 2019/3/1
 */
public class FireFacilitySystemConfigInfoParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 系统类型
            int systemType = buf.readUnsignedByte();
            // 系统地址
            int systemAddr = buf.readUnsignedByte();

            // 系统说明长度
            int legendLength = buf.readUnsignedByte();
            // 系统说明
            String legend = buf.readBytes(31).toString(Charset.forName("GB18030"));

            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            FireFacilitySystemConfigInfo infoObj = new FireFacilitySystemConfigInfo(systemType, systemAddr, legendLength, legend, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
