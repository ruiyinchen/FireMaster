package com.zfzn.firemaster.coder;

import com.zfzn.firemaster.domain.TcpDataPack;
import com.zfzn.firemaster.factory.MsgAnswer;
import com.zfzn.firemaster.util.Checksum;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 火警数据解码器
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-04 15:16
 */
public class FireDecoder extends ByteToMessageDecoder {
    private final Logger _logger = LoggerFactory.getLogger(FireDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {

        TcpDataPack dataPack = new TcpDataPack();
        byte[] sign = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(sign);
        if (84 == sign[0] && 68 == sign[1]) {
            dataPack.setBeginSign(sign);
            ctx.writeAndFlush(Unpooled.copiedBuffer("OK!", CharsetUtil.US_ASCII));
            list.add(dataPack);
        } else if (64 == sign[0] && 64 == sign[1]) {
            byteBuf.resetReaderIndex();
            if (new Checksum(byteBuf).passing()) {
                ctx.writeAndFlush(new MsgAnswer(byteBuf).define());

                byte[] original = new byte[byteBuf.readableBytes()];
                byteBuf.readBytes(original);
                dataPack.setOriginal(original);

                byteBuf.resetReaderIndex();
                byte[] beginSign = new byte[2];
                byteBuf.readBytes(beginSign);
                dataPack.setBeginSign(beginSign);

                {
                    // 获取流水号
                    short low = byteBuf.readUnsignedByte();
                    int high = byteBuf.readUnsignedByte();
                    dataPack.setSerialNumber(high << 8 + low);
                }

                dataPack.setMainVersionNo(byteBuf.readUnsignedByte());
                dataPack.setUserVersionNo(byteBuf.readUnsignedByte());

                dataPack.setTime(DateUtils.bufToDate(byteBuf.readBytes(6)));

                byte[] addr = new byte[6];
                byteBuf.readBytes(addr);
                dataPack.setSourceAddress(addr);
                byteBuf.readBytes(addr);
                dataPack.setTargetAddress(addr);

                int dataLength;
                {
                    // 获取流水号
                    byte[] sn = new byte[2];
                    byteBuf.readBytes(sn);
                    dataLength = (sn[1] << 8) & 0xFF | sn[0] & 0xFF;
                    dataPack.setSerialNumber(dataLength);
                }

                dataPack.setCommand(byteBuf.readUnsignedByte());

                dataPack.setData(byteBuf.readBytes(dataLength));

                dataPack.setChecksum(byteBuf.readUnsignedByte());

                byte[] EndSign = new byte[2];
                byteBuf.readBytes(EndSign);
                dataPack.setEndSign(EndSign);

                list.add(dataPack);
            } else {
                ctx.writeAndFlush(new MsgAnswer(byteBuf).negative());
            }
        }
    }
}
