package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.StatusRecordUserInfoFacility;

public interface StatusRecordUserInfoFacilityMapper {

    int deleteById(Long id);

    int insert(StatusRecordUserInfoFacility record);

    int insertSelective(StatusRecordUserInfoFacility record);

    StatusRecordUserInfoFacility selectById(Long id);

    int updateByIdSelective(StatusRecordUserInfoFacility record);

    int updateById(StatusRecordUserInfoFacility record);
}