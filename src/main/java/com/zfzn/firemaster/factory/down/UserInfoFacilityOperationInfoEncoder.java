package com.zfzn.firemaster.factory.down;

import com.zfzn.firemaster.domain.down.CommandItem;
import com.zfzn.firemaster.domain.down.UserInfoFacilityOperationInfo;
import com.zfzn.firemaster.factory.EncoderObject;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;

/**
 * 读用户信息传输装置操作信息记录 编码
 *
 * @author : Tony.fuxudong
 * Created in 15:49 2019/3/7
 */
public class UserInfoFacilityOperationInfoEncoder implements EncoderObject {
    @Override
    public void writeUnitData(CommandItem item, ByteBuf byteBuf) {
        UserInfoFacilityOperationInfo obj = (UserInfoFacilityOperationInfo) item;
        byteBuf.writeByte(obj.getRecordNum());
        byteBuf.writeBytes(DateUtils.dateToBuf(obj.getStartTime()));
        byteBuf.writeBytes(DateUtils.dateToBuf(obj.getTriggerTime() != null ? obj.getTriggerTime() : new Date()));
    }

    @Override
    public int itemLength() {
        return 13;
    }
}
