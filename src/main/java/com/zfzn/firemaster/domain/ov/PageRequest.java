package com.zfzn.firemaster.domain.ov;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页请求结构
 *
 * @author : Tony.fuxudong
 * Created in 10:28 2018/6/2
 */
@ApiModel("分页请求结构")
public class PageRequest<T> {
    @ApiModelProperty("页编号")
    private int pageNum;

    @ApiModelProperty("页大小")
    private int pageSize;

    @ApiModelProperty("用户授权识别码")
    private String token;

    @ApiModelProperty("请求参数")
    private T parameter;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getParameter() {
        return parameter;
    }

    public void setParameter(T parameter) {
        this.parameter = parameter;
    }
}
