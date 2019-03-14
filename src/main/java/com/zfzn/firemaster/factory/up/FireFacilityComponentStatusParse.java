package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.FireFacilityComponentStatus;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 建筑消防设施部件状态解析
 *
 * @author : Tony.fuxudong
 * Created in 17:16 2019/2/28
 */
public class FireFacilityComponentStatusParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 系统类型
            short systemType = buf.readUnsignedByte();
            // 系统地址
            short systemAddr = buf.readUnsignedByte();
            // 部件类型
            short partType = buf.readUnsignedByte();

            // 部件地址
            byte[] ac = new byte[4];
            buf.readBytes(ac);
            // 位号
            int partPlace = (ac[1] << 8) & 0xFF | ac[0] & 0xFF;
            // 区号
            int partArea = (ac[3] << 8) & 0xFF | ac[2] & 0xFF;
            // 地址码
            int addrCode = (ac[3] << 24) & 0xFFFFFF | ac[2] << 16 & 0xFFFFFF | (ac[1] << 8) & 0xFFFFFF | ac[0] & 0xFFFFFF;

            // 部件状态
            byte[] statusArr = new byte[2];
            buf.readBytes(statusArr);
            byte[] status = CommonUtils.byteArrayTo8BinArray(statusArr);

            // 部件说明
            String partLegend = buf.readBytes(31).toString(Charset.forName("GB18030"));
            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            FireFacilityComponentStatus infoObj = new FireFacilityComponentStatus(systemType, systemAddr, partType, partArea, partPlace, addrCode, status, partLegend, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
