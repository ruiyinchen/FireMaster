package com.zfzn.firemaster.factory.down;

import com.zfzn.firemaster.domain.down.CommandItem;
import com.zfzn.firemaster.domain.down.UserInfoFacilityRead;
import com.zfzn.firemaster.factory.EncoderObject;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;

/**
 * 读用户信息传输装置 编码
 * 1.用户信息传输装置运行状态
 * 2.用户信息传输装置软件版本
 * 3.用户信息传输装置配置情况
 * 4.读用户信息传输装置系统时间
 *
 * @author : Tony.fuxudong
 * Created in 15:45 2019/3/7
 */
public class UserInfoFacilityReadEncoder implements EncoderObject {

    @Override
    public void writeUnitData(CommandItem item, ByteBuf byteBuf) {
        UserInfoFacilityRead obj = (UserInfoFacilityRead) item;
        byteBuf.writeBytes(CommonUtils.intToHexBytes(obj.getReserved()));
        byteBuf.writeBytes(DateUtils.dateToBuf(obj.getTriggerTime() != null ? obj.getTriggerTime() : new Date()));
    }

    @Override
    public int itemLength() {
        return 14;
    }
}
