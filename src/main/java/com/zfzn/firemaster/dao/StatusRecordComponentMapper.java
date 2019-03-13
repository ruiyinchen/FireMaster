package com.zfzn.firemaster.dao;


import com.zfzn.firemaster.domain.od.StatusRecordComponent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StatusRecordComponentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StatusRecordComponent record);

    int insertSelective(StatusRecordComponent record);

    StatusRecordComponent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StatusRecordComponent record);

    int updateByPrimaryKey(StatusRecordComponent record);
}