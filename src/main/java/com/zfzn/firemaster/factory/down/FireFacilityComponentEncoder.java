package com.zfzn.firemaster.factory.down;

import com.zfzn.firemaster.domain.down.CommandItem;
import com.zfzn.firemaster.domain.down.FireFacilityComponentRead;
import com.zfzn.firemaster.factory.EncoderObject;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;

/**
 * 读部件信息 编码
 * 1.读建筑消防设施系统部件状态
 * 2.读建筑消防设施部件模拟量值
 * 3.读建筑消防设施部件配置情况
 *
 * @author : Tony.fuxudong
 * Created in 15:31 2019/3/7
 */
public class FireFacilityComponentEncoder implements EncoderObject {
    @Override
    public void writeUnitData(CommandItem item, ByteBuf byteBuf) {
        FireFacilityComponentRead obj = (FireFacilityComponentRead) item;
        byteBuf.writeByte(obj.getSystemType());
        byteBuf.writeByte(obj.getSystemAddr());
        byteBuf.writeBytes(CommonUtils.intToByteArray(obj.getPartPlace()));
        byteBuf.writeBytes(CommonUtils.intToByteArray(obj.getPartArea()));
        byteBuf.writeBytes(DateUtils.dateToBuf(obj.getTriggerTime() != null ? obj.getTriggerTime() : new Date()));
    }

    @Override
    public int itemLength() {
        return 12;
    }
}
