package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.FireFacilityComponentStatus;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

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
            int systemType = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 系统地址
            int systemAddr = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 部件类型
            int partType = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 部件地址
            int partArea = 0;
            {
                // 区号
                String low = buf.readBytes(2).toString(UTF_8);
                String high = buf.readBytes(2).toString(UTF_8);
                partArea = Integer.parseInt(high + low, 16);
            }
            int partPlace = 0;
            {
                // 位号
                String low = buf.readBytes(2).toString(UTF_8);
                String high = buf.readBytes(2).toString(UTF_8);
                partPlace = Integer.parseInt(high + low, 16);
            }
            // 部件状态
            String sysStatusStr = buf.readBytes(4).toString(UTF_8);
            byte[] sysStatus = null;
            try {
                sysStatus = CommonUtils.hexToBin(sysStatusStr);

            } catch (DataFormatException e) {
                e.printStackTrace();
            }
            // 部件说明
            String partLegend = buf.readBytes(62).toString(Charset.forName("GB18030"));
            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            FireFacilityComponentStatus infoObj = new FireFacilityComponentStatus(systemType, systemAddr, partType, partArea, partPlace, sysStatus, partLegend, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
