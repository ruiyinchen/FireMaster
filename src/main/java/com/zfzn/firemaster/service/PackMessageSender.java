package com.zfzn.firemaster.service;

import com.zfzn.firemaster.domain.bo.PackInfo;

/**
 * 消息发送器接口
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-11 10:58
 */
public interface PackMessageSender {
    String PACK_QUEUE="pack_queue";

    void sendMessage(PackInfo packInfo);
}
