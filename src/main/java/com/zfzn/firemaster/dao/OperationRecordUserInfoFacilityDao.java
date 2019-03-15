package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.OperationRecordUserInfoFacility;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OperationRecordUserInfoFacilityDao {

    int deleteById(Long id);

    int insert(OperationRecordUserInfoFacility record);

    int insertSelective(OperationRecordUserInfoFacility record);

    OperationRecordUserInfoFacility selectById(Long id);

    /**
     * 批量插入用户传输装置操作记录
     *
     * @param list
     * @return
     */
    int insertAll(List<OperationRecordUserInfoFacility> list);
}