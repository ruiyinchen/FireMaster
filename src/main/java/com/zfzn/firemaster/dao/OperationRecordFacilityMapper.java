package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.OperationRecordFacility;

public interface OperationRecordFacilityMapper {

    int deleteById(Long id);

    int insert(OperationRecordFacility record);

    int insertSelective(OperationRecordFacility record);

    OperationRecordFacility selectById(Long id);

    int updateByIdSelective(OperationRecordFacility record);

    int updateById(OperationRecordFacility record);
}