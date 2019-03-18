package com.zfzn.firemaster.domain.ov;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页信息
 *
 * @author : Tony.fuxudong
 * Created in 14:54 2018/6/12
 */
@ApiModel("分页")
public class Pagination {
    @ApiModelProperty(value = "当前页")
    private int current;
    @ApiModelProperty(value = "每页的数量")
    private int pageSize;
    @ApiModelProperty(value = "总页数")
    private long total;
    @ApiModelProperty(value = "是否到最后的节点")
    private boolean leaf;

    public Pagination(int current, int pageSize, long total) {
        this.current = current;
        this.pageSize = pageSize;
        this.total = total;
        if (current * pageSize >= total) {
            leaf = true;
        }
    }

    public Pagination() {
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
