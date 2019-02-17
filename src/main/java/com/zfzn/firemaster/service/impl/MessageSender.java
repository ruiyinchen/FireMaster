package com.zfzn.firemaster.service.impl;

import com.alibaba.fastjson.JSON;
import com.zfzn.firemaster.domain.bo.PackInfo;
import com.zfzn.firemaster.service.PackMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息发送器
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-11 09:47
 */
@Component
public class MessageSender implements PackMessageSender {

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public MessageSender(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void sendMessage(PackInfo packInfo){
        String msg = JSON.toJSONString(packInfo);
        stringRedisTemplate.convertAndSend(PACK_QUEUE,msg);
    }
}
