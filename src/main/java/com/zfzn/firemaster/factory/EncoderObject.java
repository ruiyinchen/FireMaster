package com.zfzn.firemaster.factory;

import com.zfzn.firemaster.domain.down.CommandItem;
import com.zfzn.firemaster.domain.down.IssuedCommand;
import com.zfzn.firemaster.util.CommonUtils;
import io.netty.buffer.ByteBuf;

import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 下行指令编码接口接口
 *
 * @author : Tony.fuxudong
 * Created in 9:35 2019/3/7
 */
public interface EncoderObject {
    int FIXED_LENGTH = 4;

    /**
     * 编码处理方法
     *
     * @param command
     * @param byteBuf
     * @return
     */
    default ByteBuf convert(IssuedCommand command, ByteBuf byteBuf) {
        writeCommon(command, byteBuf);

        List<? extends CommandItem> list = command.getList();
        list.forEach(item -> writeUnitData(item,byteBuf));
        return byteBuf;
    }

    void writeUnitData(CommandItem item,ByteBuf byteBuf);

    /**
     * 写入共有的数据信息
     *
     * @param command
     * @param byteBuf
     */
    default void writeCommon(IssuedCommand command, ByteBuf byteBuf) {
        writeDataUnitLength(command.getObjNum(), byteBuf);
        writeCommand(byteBuf);
        byteBuf.writeBytes(CommonUtils.intTo2Hex(command.getDataType()).getBytes(UTF_8));
        byteBuf.writeBytes(CommonUtils.intTo2Hex(command.getObjNum()).getBytes(UTF_8));
    }

    /**
     * 写入应用数据单元长度
     *
     * @param objNum
     * @param byteBuf
     */
    default void writeDataUnitLength(int objNum, ByteBuf byteBuf) {
        int dataLength = objNum * itemLength() + FIXED_LENGTH;
        byteBuf.writeBytes(CommonUtils.intTo4Hex(dataLength).getBytes(UTF_8));
    }

    /**
     * 写入命令
     *
     * @param byteBuf
     */
    default void writeCommand(ByteBuf byteBuf) {
        byteBuf.writeBytes(command());
    }

    default byte[] command() {
        return new byte[]{48, 52};
    }

    default int itemLength() {
        return 0;
    }
}
