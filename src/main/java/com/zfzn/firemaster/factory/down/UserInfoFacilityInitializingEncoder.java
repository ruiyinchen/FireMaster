package com.zfzn.firemaster.factory.down;

import com.zfzn.firemaster.domain.down.CommandItem;
import com.zfzn.firemaster.domain.down.UserInfoFacilityInitializing;
import com.zfzn.firemaster.factory.EncoderObject;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;

/**
 * 初始化用户信息传输装置 编码
 *
 * @author : Tony.fuxudong
 * Created in 16:02 2019/3/7
 */
public class UserInfoFacilityInitializingEncoder implements EncoderObject {
    @Override
    public void writeUnitData(CommandItem item, ByteBuf byteBuf) {
        UserInfoFacilityInitializing obj = (UserInfoFacilityInitializing) item;
        byteBuf.writeByte(obj.getReserved());
        byteBuf.writeBytes(DateUtils.dateToBuf(obj.getTriggerTime() != null ? obj.getTriggerTime() : new Date()));
    }

    @Override
    public byte command() {
        // TODO 初始化用户传输装置的命令类型有待确认
        return 1;
    }

    @Override
    public int itemLength() {
        return 7;
    }
}
