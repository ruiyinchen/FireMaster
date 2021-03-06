package com.zfzn.firemaster.server;

import com.zfzn.firemaster.coder.FireDecoder;
import com.zfzn.firemaster.coder.FireEncoder;
import com.zfzn.firemaster.handler.ActiveInboundHandler;
import com.zfzn.firemaster.handler.DataAnalysisHandler;
import com.zfzn.firemaster.handler.OriginalInboundHandler;
import com.zfzn.firemaster.handler.TransmitOutBoundHandler;
import com.zfzn.firemaster.manager.FireDataStorage;
import com.zfzn.firemaster.service.PackMessageSender;
import com.zfzn.firemaster.service.impl.MessageSender;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 消防主站中心服务器
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-03 17:38
 */
public class FireControlServer {
    /**
     * 远程连接通道
     */
    private static final Map<String, ChannelHandlerContext> channelContainer = Collections.synchronizedMap(new HashMap<>());
    /**
     * 末端集合
     */
    private static final Map<String, ChannelHandlerContext> endSet = Collections.synchronizedMap(new HashMap<>());

    private final Logger _logger = LoggerFactory.getLogger(getClass());

    private EventLoopGroup boss;
    private EventLoopGroup worker;
    private ChannelFuture future;

    private int port;

    public FireControlServer() {
        this(10010);
    }

    public FireControlServer(int port) {
        this.port = port;
        boss = new NioEventLoopGroup(1);
        worker = new NioEventLoopGroup();
    }

    /**
     * 启动服务器
     */
    public void start(PackMessageSender messageSender) {
        ServerBootstrap bootstrap = new ServerBootstrap();

        ActiveInboundHandler activeHandler = new ActiveInboundHandler(channelContainer,endSet);
        OriginalInboundHandler originalInboundHandler = new OriginalInboundHandler(messageSender);
        DataAnalysisHandler analysisHandler = new DataAnalysisHandler(messageSender);
//        TransmitOutBoundHandler transmitHandler = new TransmitOutBoundHandler();

        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
//                .childOption(ChannelOption.SO_BACKLOG, 4 * 1024)
//                .childOption(ChannelOption.SO_SNDBUF, 8 * 1024)
//                .childOption(ChannelOption.SO_RCVBUF, 8 * 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel channel) {
                        channel.pipeline().addLast(new FireDecoder());
                        channel.pipeline().addLast(activeHandler);
                        channel.pipeline().addLast(originalInboundHandler);
                        channel.pipeline().addLast(analysisHandler);
                        channel.pipeline().addLast(new FireEncoder());
//                        channel.pipeline().addLast(transmitHandler);
                    }
                });

        future = bootstrap.bind(port)
                .addListener((ChannelFutureListener) channelFuture ->
                        _logger.info("Fire Control Server started！port:{}", port));
        future.channel()
                .closeFuture()
                .addListener((ChannelFutureListener) channelFuture -> stop());
    }

    /**
     * 停止服务器线程组，释放资源
     */
    void stop() {
        if (boss != null) {
            try {
                boss.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (worker != null) {
            try {
                worker.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        _logger.info("Fire Control Server stopped!");
    }

    public void send(ByteBuf byteBuf) {
        channelContainer.forEach((key, ctx) -> ctx.writeAndFlush(byteBuf));
    }

    public void sendTo(ByteBuf byteBuf) {
        endSet.forEach((key, ctx) -> ctx.writeAndFlush(byteBuf.copy()));
        ReferenceCountUtil.release(byteBuf);
    }
}
