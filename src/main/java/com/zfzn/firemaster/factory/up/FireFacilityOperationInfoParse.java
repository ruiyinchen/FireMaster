package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.FireFacilityOperationInfo;
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
 * 建筑消防设施操作信息解析
 *
 * @author : Tony.fuxudong
 * Created in 9:13 2019/3/1
 */
public class FireFacilityOperationInfoParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 系统类型
            int systemType = buf.readUnsignedByte();
            // 系统地址
            int systemAddr = buf.readUnsignedByte();

            // 操作标志
            short operationalSignValue = buf.readUnsignedByte();
            byte[] operationalSign = CommonUtils.intTo8BinArray(operationalSignValue);

            // 操作员编号
            int operatorNo = buf.readUnsignedByte();
            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            FireFacilityOperationInfo infoObj = new FireFacilityOperationInfo(systemType, systemAddr, operationalSign, operatorNo, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
