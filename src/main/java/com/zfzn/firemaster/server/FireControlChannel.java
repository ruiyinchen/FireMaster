package com.zfzn.firemaster.server;

import com.zfzn.firemaster.domain.down.IssuedCommand;
import com.zfzn.firemaster.factory.EncoderObject;
import com.zfzn.firemaster.factory.down.PackEncoder;
import com.zfzn.firemaster.manager.FireDataStorage;
import com.zfzn.firemaster.service.impl.MessageSender;
import io.netty.buffer.ByteBuf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 服务器通道
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
    private final FireDataStorage storage;

    @Autowired
    public FireControlChannel(PackEncoder packEncoder, MessageSender messageSender, FireDataStorage storage) {
        this.packEncoder = packEncoder;
        this.messageSender = messageSender;
        this.storage = storage;
    }

    @PostConstruct
    private void init() {
        server = ALLOW_START ? new FireControlServer(port) : null;
        if (ALLOW_START) {
            server.start(messageSender,storage);
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
}
