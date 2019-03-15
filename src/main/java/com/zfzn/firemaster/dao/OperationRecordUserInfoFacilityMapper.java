package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.OperationRecordUserInfoFacility;

public interface OperationRecordUserInfoFacilityMapper {

    int deleteById(Long id);

    int insert(OperationRecordUserInfoFacility record);

    int insertSelective(OperationRecordUserInfoFacility record);

    OperationRecordUserInfoFacility selectById(Long id);

    int updateByIdSelective(OperationRecordUserInfoFacility record);

    int updateById(OperationRecordUserInfoFacility record);
}