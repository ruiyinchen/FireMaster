package com.zfzn.firemaster.server;

import com.zfzn.firemaster.service.impl.MessageSender;
import com.zfzn.firemaster.util.SpringContextUtil;
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

    @Value("${fire-control.server.allow-start}")
    private boolean ALLOW_START = false;
    @Value("${fire-control.server.port}")
    private int port;
    private final MessageSender messageSender;

    @Autowired
    public FireControlChannel(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @PostConstruct
    private void init() {
        server = ALLOW_START ? new FireControlServer(port) : null;
        if (ALLOW_START){
            server.start(messageSender);
        }
    }

    @PreDestroy
    private void destroy() {
        if (server != null) {
            server.stop();
        }
    }
}
