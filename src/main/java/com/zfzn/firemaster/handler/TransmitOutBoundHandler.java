package com.zfzn.firemaster.handler;

import io.netty.channel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据出栈 Handler
 *
 * @author : Tony.fuxudong
 * Created in 9:19 2019/3/5
 */
@ChannelHandler.Sharable
public class TransmitOutBoundHandler extends ChannelOutboundHandlerAdapter {

    private final Logger _logger = LoggerFactory.getLogger(TransmitOutBoundHandler.class);

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
//        super.write(ctx, msg, promise);
        _logger.info(msg.toString());
    }
}
