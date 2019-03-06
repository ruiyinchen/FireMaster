package com.zfzn.firemaster.coder;

import com.zfzn.firemaster.domain.TcpDataPack;
import com.zfzn.firemaster.factory.MsgAnswer;
import com.zfzn.firemaster.util.Checksum;
import com.zfzn.firemaster.util.DateUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static io.netty.util.CharsetUtil.UTF_8;

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
        if (new Checksum(byteBuf).passing()) {
            ctx.writeAndFlush(new MsgAnswer(byteBuf).define());

            TcpDataPack dataPack = new TcpDataPack();
            // original
            dataPack.setOriginal(byteBuf.toString(UTF_8));
            // 得到起始符号
            {
                String low = byteBuf.readBytes(2).toString(UTF_8);
                String high = byteBuf.readBytes(2).toString(UTF_8);
                dataPack.setBeginSign(high + low);
            }
            // 获取流水号
            {
                String low = byteBuf.readBytes(2).toString(UTF_8);
                String high = byteBuf.readBytes(2).toString(UTF_8);
                dataPack.setSerialNumber(high + low);
            }
            // 获取主版本号
            dataPack.setMainVersionNo(Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16));
            // 获取用户版本号
            dataPack.setUserVersionNo(Integer.parseInt(byteBuf.readBytes(2).toString(UTF_8), 16));
            // 获取时间
            dataPack.setTime(DateUtils.bufToDate(byteBuf));
            // 获取源地址
            {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    builder.insert(0, byteBuf.readBytes(2).toString(UTF_8));
                }
                dataPack.setSourceAddress(builder.toString());
            }
            // 获取目标地址
            {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 6; i++) {
                    builder.insert(0, byteBuf.readBytes(2).toString(UTF_8));
                }
                dataPack.setTargetAddress(builder.toString());

            }
            // 获取应用数据单元长度
            int dataLength = 0;
            {
                String low = byteBuf.readBytes(2).toString(UTF_8);
                String high = byteBuf.readBytes(2).toString(UTF_8);
                dataLength = Integer.parseInt(high + low, 16);
                dataPack.setDataLength(dataLength);
            }
            // 获取命令
            {
                String commandStr = byteBuf.readBytes(2).toString(UTF_8);
                dataPack.setCommand(Integer.parseInt(commandStr, 16));
            }
            // 获取应用数据单元
            dataPack.setData(byteBuf.readBytes(2 * dataLength).copy());
            // 获取校验和
            dataPack.setChecksum(byteBuf.readBytes(2).toString(UTF_8));
            // 得到结束符号
            {
                String low = byteBuf.readBytes(2).toString(UTF_8);
                String high = byteBuf.readBytes(2).toString(UTF_8);
                dataPack.setEndSign(high + low);
            }

            list.add(dataPack);
        } else {
            ctx.writeAndFlush(new MsgAnswer(byteBuf).negative());
            // 此语句必须存在，否则将导致粘包，
            byteBuf.clear();    // 1
            // 不可添加用一些代码代替代码1，否则会出现异常
//            ReferenceCountUtil.release(byteBuf);  // 2
        }
    }
}
