package com.zfzn.firemaster.domain.ov;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

import static com.zfzn.firemaster.domain.ov.ResultEnum.SUCCESS;

/**
 * 响应数据结构
 *
 * @author : Tony.fuxudong
 * Created in 8:26 2018/6/2
 */
@ApiModel("响应数据结构")
public class Result {
    @ApiModelProperty("结果码")
    private int code;
    @ApiModelProperty("信息描述")
    private String msg;
    @ApiModelProperty("响应数据")
    private Object result;
    @ApiModelProperty("页信息")
    private Pagination page;

    public static Result success() {
        return newInstance(SUCCESS, null);
    }

    public static Result success(Object obj) {
        return newInstance(SUCCESS, obj);
    }

    public static Result success(String msg) {
        return new Result(SUCCESS.getCode(), msg, null);
    }

    public static Result success(String msg, Object obj) {
        return new Result(SUCCESS.getCode(), msg, obj);
    }

    public static Result newInstance(@NotNull ResultEnum resultEnum) {
        return new Result(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    public static Result newInstance(@NotNull ResultEnum resultEnum, String msg) {
        return new Result(resultEnum.getCode(), msg, null);
    }

    public static Result newInstance(@NotNull ResultEnum resultEnum, Object obj) {
        return new Result(resultEnum.getCode(), resultEnum.getMsg(), obj);
    }

    public static Result newInstance(@NotNull ResultEnum resultEnum, String msg, Object obj) {
        return new Result(resultEnum.getCode(), msg, obj);
    }

    public Result(int code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public Result() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Pagination getPage() {
        return page;
    }

    public void setPage(Pagination page) {
        this.page = page;
    }
}
