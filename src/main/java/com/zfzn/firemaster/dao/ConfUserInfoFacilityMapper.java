package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.ConfUserInfoFacility;

public interface ConfUserInfoFacilityMapper {
    int deleteById(Long id);

    int insert(ConfUserInfoFacility record);

    int insertSelective(ConfUserInfoFacility record);

    ConfUserInfoFacility selectById(Long id);

    int updateByIdSelective(ConfUserInfoFacility record);

    int updateById(ConfUserInfoFacility record);
}