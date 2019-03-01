package com.zfzn.firemaster.factory.decode;

import com.zfzn.firemaster.domain.en.FireFacilitySystemStatus;
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
            int systemType = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 系统地址
            int systemAddr = Integer.parseInt(buf.readBytes(2).toString(UTF_8), 16);
            // 系统状态
            String sysStatusStr = buf.readBytes(4).toString(UTF_8);
            byte[] sysStatus=null;
            try {
                sysStatus= CommonUtils.hexToBin(sysStatusStr);

            } catch (DataFormatException e) {
                e.printStackTrace();
            }
            // 状态发生时间
            Date triggerTime=DateUtils.bufToDate(buf);

            FireFacilitySystemStatus infoObj=new FireFacilitySystemStatus(systemType,systemAddr,sysStatus,triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
