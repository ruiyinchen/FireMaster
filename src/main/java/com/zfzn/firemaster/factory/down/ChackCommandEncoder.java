package com.zfzn.firemaster.factory.down;

import com.zfzn.firemaster.domain.down.CheckCommand;
import com.zfzn.firemaster.domain.down.CommandItem;
import com.zfzn.firemaster.factory.EncoderObject;
import com.zfzn.firemaster.util.CommonUtils;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;

import java.util.Date;

/**
 * 查岗命令 编码
 *
 * @author : Tony.fuxudong
 * Created in 16:14 2019/3/7
 */
public class ChackCommandEncoder implements EncoderObject {
    @Override
    public void writeUnitData(CommandItem item, ByteBuf byteBuf) {
        CheckCommand obj = (CheckCommand) item;
        byteBuf.writeBytes(CommonUtils.intToHexBytes(obj.getOvertime()));
        byteBuf.writeBytes(DateUtils.dateToBuf(obj.getTriggerTime() != null ? obj.getTriggerTime() : new Date()));
    }

    @Override
    public byte[] command() {
        return new byte[]{48, 49};
    }

    @Override
    public int itemLength() {
        return 14;
    }
}
