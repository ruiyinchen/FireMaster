package com.zfzn.firemaster.dao;


import com.zfzn.firemaster.domain.od.StatusRecordSystem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StatusRecordSystemMapper {
    int deleteById(Long id);

    int insert(StatusRecordSystem record);

    int insertSelective(StatusRecordSystem record);

    StatusRecordSystem selectById(Long id);

    int updateByIdSelective(StatusRecordSystem record);

    int updateById(StatusRecordSystem record);
}