package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.FireFacilityComponentConfigInfo;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 建筑消防设施系统部件配置情况
 *
 * @author : Tony.fuxudong
 * Created in 10:04 2019/3/1
 */
public class FireFacilityComponentConfigInfoParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list=new LinkedList<>();
        for(int i=0;i<objNum;i++){
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
            // TODO 添加地址码
            int addrCode = (ac[3] << 24) & 0xFFFFFF | ac[2] << 16 & 0xFFFFFF | (ac[1] << 8) & 0xFFFFFF | ac[0] & 0xFFFFFF;

            // 部件说明
            String partLegend = buf.readBytes(31).toString(Charset.forName("GB18030"));
            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            FireFacilityComponentConfigInfo infoObj = new FireFacilityComponentConfigInfo(systemType, systemAddr, partType, partArea, partPlace, partLegend, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
