package com.zfzn.firemaster.factory.up;

import com.zfzn.firemaster.domain.up.UserInfoFacilitySwitchStatus;
import com.zfzn.firemaster.factory.ParseObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 用户传输装置开关量状态 解析
 *
 * @author : Tony.fuxudong
 * Created in 11:39 2019/3/5
 */
public class UserInfoFacilitySwitchStatusParse implements ParseObject {
    @Override
    public List<Object> analyze(ByteBuf buf, int objNum) {
        List<Object> list = new LinkedList<>();
        for (int i = 0; i < objNum; i++) {
            // 系统地址
            byte[] sysArr=new byte[2];
            buf.readBytes(sysArr);
            int systemAddr = (sysArr[1] << 8) & 0xFF | sysArr[0] & 0xFF;

            buf.readBytes(8);
            // 开关量位置
            int switchPosition = buf.readUnsignedByte();
            // 状态
            int status = buf.readUnsignedByte();

            buf.readBytes(4);
            // 状态发生时间
            Date triggerTime = DateUtils.bufToDate(buf);

            UserInfoFacilitySwitchStatus infoObj = new UserInfoFacilitySwitchStatus(systemAddr, switchPosition, status, triggerTime);
            list.add(infoObj);
        }
        return list;
    }
}
