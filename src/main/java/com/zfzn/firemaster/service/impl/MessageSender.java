package com.zfzn.firemaster.service.impl;

import com.alibaba.fastjson.JSON;
import com.zfzn.firemaster.cache.FireDataCache;
import com.zfzn.firemaster.cache.GlobalValueAdapter;
import com.zfzn.firemaster.domain.TcpDataPack;
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
    private final FireDataCache fireDataCache;

    @Autowired
    public MessageSender(StringRedisTemplate stringRedisTemplate, FireDataCache fireDataCache) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.fireDataCache = fireDataCache;
    }

    @Override
    public void sendMessage(PackInfo packInfo, TcpDataPack dataPack) {
        String msg = JSON.toJSONString(packInfo);
        stringRedisTemplate.convertAndSend(PACK_QUEUE, msg);

        // 将保存用户传输装置信息，以便下发信息使用
        fireDataCache.learnGlobal(packInfo.getHost(), new GlobalValueAdapter(dataPack).value());
    }
}
