package com.zfzn.firemaster.handler;

import com.google.common.base.Joiner;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;

/**
 * 客户端连接检测 Handler
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-03 17:44
 */
@ChannelHandler.Sharable
public class ActiveInboundHandler extends ChannelInboundHandlerAdapter {
    private Logger _logger = LoggerFactory.getLogger(getClass());

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress socketAddr = (InetSocketAddress) ctx.channel().remoteAddress();
        _logger.info(Joiner.on(' ').skipNulls().join(
                "Remote Client:" ,
                socketAddr.getHostString() ,
                ":" ,
                socketAddr.getPort(),
                "Connected!"));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress socketAddr = (InetSocketAddress) ctx.channel().remoteAddress();
        _logger.info(Joiner.on(' ').skipNulls().join(
                "Remote Client:",
                socketAddr.getHostString() ,
                ":" ,
                socketAddr.getPort(),
                "Disconnected!"));
    }
}
