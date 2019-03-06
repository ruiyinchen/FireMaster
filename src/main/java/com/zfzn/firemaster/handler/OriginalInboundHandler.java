package com.zfzn.firemaster.handler;

import com.zfzn.firemaster.cache.FireDataCache;
import com.zfzn.firemaster.domain.TcpDataPack;
import com.zfzn.firemaster.domain.bo.PackInfo;
import com.zfzn.firemaster.service.PackMessageSender;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetSocketAddress;

/**
 * 信息发送 handler
 * 将收到的消息发送到消息队列
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-11 11:04
 */
@ChannelHandler.Sharable
public class OriginalInboundHandler extends ChannelInboundHandlerAdapter {
    private final PackMessageSender messageSender;

    public OriginalInboundHandler(PackMessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TcpDataPack dataPack=(TcpDataPack)msg;
        InetSocketAddress socketAddr = (InetSocketAddress) ctx.channel().remoteAddress();
        PackInfo packInfo=new PackInfo(socketAddr.getHostString()+":"+socketAddr.getPort(),dataPack.getOriginal());
        messageSender.sendMessage(packInfo);
        messageSender.cache(dataPack);
        ctx.fireChannelRead(msg);
    }
}
