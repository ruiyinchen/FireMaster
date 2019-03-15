package com.zfzn.firemaster.dao;


import com.zfzn.firemaster.domain.od.OperationRecordFacility;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OperationRecordFacilityDao {

    int deleteById(Long id);

    int insert(OperationRecordFacility record);

    int insertSelective(OperationRecordFacility record);

    OperationRecordFacility selectById(Long id);

    /**
     * 批量插入建筑消防设施操作记录
     * @param list
     * @return
     */
    int insertAll(List<OperationRecordFacility> list);
}