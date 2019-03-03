package com.zfzn.firemaster.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 火警数据编码器
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-04 15:11
 */
public class FireEncoder extends MessageToByteEncoder {
    private final Logger _logger= LoggerFactory.getLogger(FireEncoder.class);
    @Override
    protected void encode(ChannelHandlerContext ctx, Object obj, ByteBuf byteBuf) throws Exception {
        _logger.info("编码器被调用了!");
    }
}
