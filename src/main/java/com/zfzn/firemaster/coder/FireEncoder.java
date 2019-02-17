package com.zfzn.firemaster.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 火警数据编码器
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-04 15:11
 */
public class FireEncoder extends MessageToByteEncoder {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object obj, ByteBuf byteBuf) throws Exception {

    }
}
