package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.StatusRecordUserInfoFacility;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StatusRecordUserInfoFacilityDao {

    int deleteById(Long id);

    int insert(StatusRecordUserInfoFacility record);

    int insertSelective(StatusRecordUserInfoFacility record);

    StatusRecordUserInfoFacility selectById(Long id);

    /**
     * 批量插入用户传输装置运行状态记录
     * @param list
     * @return
     */
    int insertAll(List<StatusRecordUserInfoFacility> list);
}