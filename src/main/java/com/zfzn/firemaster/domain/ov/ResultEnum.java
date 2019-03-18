package com.zfzn.firemaster.domain.ov;

import io.swagger.annotations.ApiModel;

/**
 * 返回状态结果码枚举值
 *
 * @author : Tony.fuxudong
 * Created in 8:38 2018/6/2
 */
@ApiModel("同一消息封装")
public enum ResultEnum {
    SUCCESS(10, "success"),
    UNKNOWN_ERROR(11, "unknown error"),
    PARAMETER_ERROR(12, "parameter error"),
    PERMISSION_DENIED(13, "permission denied"),
    EXCEPTION(14, "exception"),
    NO_RESULT(15, "no data"),
    FAILURE(16, "failure");

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
