package com.zfzn.firemaster.dao;


import com.zfzn.firemaster.domain.od.StatusRecordComponent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StatusRecordComponentDao {
    int deleteById(Long id);

    int insert(StatusRecordComponent record);

    int insertSelective(StatusRecordComponent record);

    StatusRecordComponent selectById(Long id);

    /**
     * 批量插入部件状态记录
     *
     * @param list
     * @return
     */
    int insertAll(@Param("list") List<StatusRecordComponent> list);

    /**
     * 根据地址码查询部件状态
     *
     * @param addrCode
     * @return
     */
    List<StatusRecordComponent> selectByAddrCode(@Param("addrCode") Integer addrCode);
}