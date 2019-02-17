package com.zfzn.firemaster.server;

import com.zfzn.firemaster.coder.FireDecoder;
import com.zfzn.firemaster.coder.FireEncoder;
import com.zfzn.firemaster.handler.ActiveInboundHandler;
import com.zfzn.firemaster.handler.OriginalInboundHander;
import com.zfzn.firemaster.service.PackMessageSender;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消防主站中心服务器
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-03 17:38
 */
public class FireControlServer {
    private final Logger _logger= LoggerFactory.getLogger(getClass());

    private EventLoopGroup boss;
    private EventLoopGroup worker;
    private ChannelFuture future;

    private int port;

    public FireControlServer() {
        this(10010);
    }

    public FireControlServer(int port) {
        this.port = port;
        boss = new NioEventLoopGroup();
        worker = new NioEventLoopGroup();
    }

    /**
     * 启动服务器
     */
    public void start(PackMessageSender messageSender) {
        ServerBootstrap bootstrap = new ServerBootstrap();

        ActiveInboundHandler activeHandler=new ActiveInboundHandler();
        FireEncoder encoder= new FireEncoder();
        FireDecoder decoder= new FireDecoder();
        OriginalInboundHander originalInboundHander =new OriginalInboundHander(messageSender);

        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
//                .childOption(ChannelOption.SO_BACKLOG, 4 * 1024)
//                .childOption(ChannelOption.SO_SNDBUF, 8 * 1024)
//                .childOption(ChannelOption.SO_RCVBUF, 8 * 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel channel) {
                        channel.pipeline().addLast(activeHandler);
                        channel.pipeline().addLast(decoder);
                        channel.pipeline().addLast(encoder);
                        channel.pipeline().addLast(originalInboundHander);
                    }
                });

        future = bootstrap.bind(port)
                .addListener((ChannelFutureListener) channelFuture ->
                        _logger.info("Fire Control Server started！port:{}",port));
        future.channel()
                .closeFuture()
                .addListener((ChannelFutureListener) channelFuture -> {
                    stop();
                });
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
}
