package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.FireFacilitySystemStatus;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 建筑消防设施系统状态解析
 *
 * @author : Tony.fuxudong
 * Created in 16:02 2019/2/28
 */
public class FireFacilitySystemStatusParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 系统类型
            int systemType = buf.readUnsignedByte();
            // 系统地址
            int systemAddr = buf.readUnsignedByte();

            // 系统状态
            byte[] statusArr = new byte[2];
            buf.readBytes(statusArr);
            byte[] status = CommonUtils.byteArrayTo8BinArray(statusArr);

            // 状态发生时间
            Date triggerTime=DateUtils.bufToDate(buf);

            FireFacilitySystemStatus infoObj=new FireFacilitySystemStatus(systemType,systemAddr,status,triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
