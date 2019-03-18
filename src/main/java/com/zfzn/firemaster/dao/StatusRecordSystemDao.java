package com.zfzn.firemaster.dao;


import com.zfzn.firemaster.domain.od.StatusRecordSystem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StatusRecordSystemDao {
    int deleteById(Long id);

    int insert(StatusRecordSystem record);

    int insertSelective(StatusRecordSystem record);

    StatusRecordSystem selectById(Long id);

    /**
     * 批量插入系统状态记录
     * @param list
     * @return
     */
    int insertAll(@Param("list") List<StatusRecordSystem> list);

    /**
     * 根据系统地址查询系统状态
     * @param parameter
     * @return
     */
    List<StatusRecordSystem> selectBySysAddr(Integer parameter);
}