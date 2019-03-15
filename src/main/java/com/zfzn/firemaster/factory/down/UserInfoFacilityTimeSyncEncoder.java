package com.zfzn.firemaster.factory.down;

import com.zfzn.firemaster.domain.down.CommandItem;
import com.zfzn.firemaster.domain.down.UserInfoFacilityTimeSync;
import com.zfzn.firemaster.factory.EncoderObject;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;

/**
 * 同步用户信息传输装置时间 编码
 *
 * @author : Tony.fuxudong
 * Created in 16:02 2019/3/7
 */
public class UserInfoFacilityTimeSyncEncoder implements EncoderObject {
    @Override
    public void writeUnitData(CommandItem item, ByteBuf byteBuf) {
        UserInfoFacilityTimeSync obj = (UserInfoFacilityTimeSync) item;
        byteBuf.writeBytes(DateUtils.dateToBuf(obj.getCenterTime()));
        byteBuf.writeBytes(DateUtils.dateToBuf(obj.getTriggerTime() != null ? obj.getTriggerTime() : new Date()));
    }

    @Override
    public byte command() {
        return 1;
    }

    @Override
    public int itemLength() {
        return 12;
    }
}
