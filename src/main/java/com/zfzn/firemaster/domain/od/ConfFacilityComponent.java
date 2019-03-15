package com.zfzn.firemaster.domain.od;

public class ConfFacilityComponent {
    private Long id;

    private Integer addrCode;

    private String componentDescription;

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

    public String getComponentDescription() {
        return componentDescription;
    }

    public void setComponentDescription(String componentDescription) {
        this.componentDescription = componentDescription == null ? null : componentDescription.trim();
    }
}