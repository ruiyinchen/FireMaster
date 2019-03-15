package com.zfzn.firemaster.domain.od;

import java.util.Date;

public class OperationRecordUserInfoFacility {
    private Long id;

    private Integer operationalInfo;

    private Integer operator;

    private Date gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOperationalInfo() {
        return operationalInfo;
    }

    public void setOperationalInfo(Integer operationalInfo) {
        this.operationalInfo = operationalInfo;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}