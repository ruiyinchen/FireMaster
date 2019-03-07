package com.zfzn.firemaster.factory.down;

import com.zfzn.firemaster.domain.down.CommandItem;
import com.zfzn.firemaster.domain.down.FireFacilityRead;
import com.zfzn.firemaster.factory.EncoderObject;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;

/**
 * 读建筑设施信息 编码
 * 1.读建筑消防设施系统状态
 * 2.读建筑消防设施软件版本
 * 3.读建筑消防设施系统配置情况
 * 4.读建筑消防设施系统时间
 *
 * @author : Tony.fuxudong
 * Created in 15:29 2019/3/7
 */
public class FireFacilityEncoder implements EncoderObject {
    @Override
    public void writeUnitData(CommandItem item, ByteBuf byteBuf) {
        FireFacilityRead obj = (FireFacilityRead) item;
        byteBuf.writeBytes(CommonUtils.intToHexBytes(obj.getSystemType()));
        byteBuf.writeBytes(CommonUtils.intToHexBytes(obj.getSystemAddr()));
        byteBuf.writeBytes(DateUtils.dateToBuf(obj.getTriggerTime() != null ? obj.getTriggerTime() : new Date()));
    }

    @Override
    public int itemLength() {
        return 16;
    }
}
