package com.zfzn.firemaster.server;

import com.alibaba.fastjson.JSON;
import com.zfzn.firemaster.domain.down.IssuedCommand;
import com.zfzn.firemaster.factory.EncoderObject;
import com.zfzn.firemaster.factory.down.PackEncoder;
import com.zfzn.firemaster.manager.FireDataStorage;
import com.zfzn.firemaster.service.impl.MessageSender;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * 服务器通道前往
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-03 17:47
 */
@Component
public class FireControlChannel {

    private FireControlServer server;
    private PackEncoder packEncoder;

    @Value("${fire-control.server.allow-start}")
    private boolean ALLOW_START = false;
    @Value("${fire-control.server.port}")
    private int port;
    private final MessageSender messageSender;

    @Autowired
    public FireControlChannel(PackEncoder packEncoder, MessageSender messageSender) {
        this.packEncoder = packEncoder;
        this.messageSender = messageSender;
    }

    @PostConstruct
    private void init() {
        server = ALLOW_START ? new FireControlServer(port) : null;
        if (ALLOW_START) {
            server.start(messageSender);
        }
    }

    @PreDestroy
    private void destroy() {
        if (server != null) {
            server.stop();
        }
    }

    public void send(IssuedCommand command) {
        if (server != null) {
            ByteBuf byteBuf=packEncoder.builder(command.getTarget());

            EncoderObject encoderObj=packEncoder.bodyObj(command);
            encoderObj.convert(command,byteBuf);

            packEncoder.build(byteBuf);
            server.send(byteBuf);
        }
    }

    public void sendTo(Object obj){
        String msg=JSON.toJSONString(obj);
        ByteBuf buf= Unpooled.copiedBuffer(msg,UTF_8);
        server.sendTo(buf);
    }
}
