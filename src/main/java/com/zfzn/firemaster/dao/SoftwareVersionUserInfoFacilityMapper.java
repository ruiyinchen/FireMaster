package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.SoftwareVersionUserInfoFacility;

public interface SoftwareVersionUserInfoFacilityMapper {

    int deleteById(Long id);

    int insert(SoftwareVersionUserInfoFacility record);

    int insertSelective(SoftwareVersionUserInfoFacility record);

    SoftwareVersionUserInfoFacility selectById(Long id);

    int updateByIdSelective(SoftwareVersionUserInfoFacility record);

    int updateById(SoftwareVersionUserInfoFacility record);
}