package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.SoftwareVersionFacility;

public interface SoftwareVersionFacilityMapper {

    int deleteById(Long id);

    int insert(SoftwareVersionFacility record);

    int insertSelective(SoftwareVersionFacility record);

    SoftwareVersionFacility selectById(Long id);

    int updateByIdSelective(SoftwareVersionFacility record);

    int updateById(SoftwareVersionFacility record);
}