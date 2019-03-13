package com.zfzn.firemaster.dao;


import com.zfzn.firemaster.domain.od.StatusRecordComponent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StatusRecordComponentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StatusRecordComponent record);

    int insertSelective(StatusRecordComponent record);

    StatusRecordComponent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StatusRecordComponent record);

    int updateByPrimaryKey(StatusRecordComponent record);

    /**
     * 批量插入部件状态记录
     *
     * @param list
     * @return
     */
    int insertAll(@Param("list") List<StatusRecordComponent> list);
}