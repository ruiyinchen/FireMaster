package com.zfzn.firemaster.domain.bo;

import java.io.Serializable;

/**
 * 数据包消息封装实体
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-11 09:35
 */
public class PackInfo implements Serializable {
    private static final long serialVersionUID = -1011233794643668350L;
    private String host;
    private String message;

    public PackInfo() {
    }

    public PackInfo(String host, String message) {
        this.host = host;
        this.message = message;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
