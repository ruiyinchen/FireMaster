package com.zfzn.firemaster.handler;

import com.zfzn.firemaster.domain.TcpDataPack;
import com.zfzn.firemaster.domain.bo.PackInfo;
import com.zfzn.firemaster.service.PackMessageSender;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.InetSocketAddress;

/**
 * 消息发送handler
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-11 11:04
 */
@ChannelHandler.Sharable
public class OriginalInboundHander extends ChannelInboundHandlerAdapter {
    private final PackMessageSender messageSender;

    public OriginalInboundHander(PackMessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TcpDataPack dataPack=(TcpDataPack)msg;
        InetSocketAddress socketAddr = (InetSocketAddress) ctx.channel().remoteAddress();
        PackInfo packInfo=new PackInfo(socketAddr.getHostString()+":"+socketAddr.getPort(),dataPack.getOriginal());
        messageSender.sendMessage(packInfo);
    }
}
