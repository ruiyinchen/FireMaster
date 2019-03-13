package com.zfzn.firemaster.domain.od;

import java.util.Date;

public class AnalogValue {
    private Long id;

    private Integer addrCode;

    private Integer analogType;

    private Integer analogQuantity;

    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAddrCode() {
        return addrCode;
    }

    public void setAddrCode(Integer addrCode) {
        this.addrCode = addrCode;
    }

    public Integer getAnalogType() {
        return analogType;
    }

    public void setAnalogType(Integer analogType) {
        this.analogType = analogType;
    }

    public Integer getAnalogQuantity() {
        return analogQuantity;
    }

    public void setAnalogQuantity(Integer analogQuantity) {
        this.analogQuantity = analogQuantity;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}