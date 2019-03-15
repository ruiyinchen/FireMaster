package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.StatusRecordGasExterminate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StatusRecordGasExterminateDao {
    int deleteById(Long id);

    int insert(StatusRecordGasExterminate record);

    int insertSelective(StatusRecordGasExterminate record);

    StatusRecordGasExterminate selectById(Long id);

    /**
     * 批量插入气体灭火系统状态
     *
     * @param list
     * @return
     */
    int insertAll(List<StatusRecordGasExterminate> list);
}