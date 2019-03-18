package com.zfzn.firemaster.handler;

import com.google.common.base.Joiner;
import com.zfzn.firemaster.domain.TcpDataPack;
import com.zfzn.firemaster.domain.bo.PackInfo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.Map;

/**
 * 客户端连接检测 Handler
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-03 17:44
 */
@ChannelHandler.Sharable
public class ActiveInboundHandler extends ChannelInboundHandlerAdapter {
    private Logger _logger = LoggerFactory.getLogger(getClass());

    private final Map<String, ChannelHandlerContext> channelContainer;
    private final Map<String, ChannelHandlerContext> endSet;

    public ActiveInboundHandler(Map<String, ChannelHandlerContext> channelContainer, Map<String, ChannelHandlerContext> endSet) {
        this.channelContainer = channelContainer;
        this.endSet = endSet;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TcpDataPack dataPack = (TcpDataPack) msg;
        byte[] sign = dataPack.getBeginSign();
        if (84 == sign[0] && 68 == sign[1]) {
            InetSocketAddress socketAddr = (InetSocketAddress) ctx.channel().remoteAddress();
            String key = Joiner.on(':').skipNulls().join(
                    socketAddr.getHostString(),
                    socketAddr.getPort());
            channelContainer.remove(key);
            endSet.put(key, ctx);
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress socketAddr = (InetSocketAddress) ctx.channel().remoteAddress();

        channelContainer.put(Joiner.on(':').skipNulls().join(
                socketAddr.getHostString(),
                socketAddr.getPort()), ctx);

        _logger.info(Joiner.on(' ').skipNulls().join(
                "Remote Client:",
                socketAddr.getHostString(),
                ":",
                socketAddr.getPort(),
                "Connected!"));
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress socketAddr = (InetSocketAddress) ctx.channel().remoteAddress();

        channelContainer.remove(Joiner.on(':').skipNulls().join(
                socketAddr.getHostString(),
                socketAddr.getPort()));

        _logger.info(Joiner.on(' ').skipNulls().join(
                "Remote Client:",
                socketAddr.getHostString(),
                ":",
                socketAddr.getPort(),
                "Disconnected!"));
    }
}
