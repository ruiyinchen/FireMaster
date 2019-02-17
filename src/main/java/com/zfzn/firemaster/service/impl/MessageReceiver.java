package com.zfzn.firemaster.service.impl;

import com.alibaba.fastjson.JSON;
import com.zfzn.firemaster.dao.PackOriginalDao;
import com.zfzn.firemaster.domain.bo.PackInfo;
import com.zfzn.firemaster.domain.bo.PackOriginalInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息接收器
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-11 09:50
 */

@Component
public class MessageReceiver {
    private final Logger _logger= LoggerFactory.getLogger(getClass());

    private final PackOriginalDao packOriginalDao;

    @Autowired
    public MessageReceiver(PackOriginalDao packOriginalDao) {
        this.packOriginalDao = packOriginalDao;
    }

    /**
     * 接收消息的方法
     * @param msg 消息
     */
    public void receivePackMessage(String msg){
        PackInfo packInfo= JSON.parseObject(msg, PackInfo.class);
        _logger.info("收到主机 {} 的数据包：{}", packInfo.getHost(),packInfo.getMessage());
        PackOriginalInfo packOriginal=new PackOriginalInfo(packInfo);
        packOriginalDao.insert(packOriginal);
    }
}
