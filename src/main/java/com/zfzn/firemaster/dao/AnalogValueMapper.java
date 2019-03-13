package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.AnalogValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnalogValueMapper {

    int deleteById(Long id);

    int insert(AnalogValue record);

    int insertSelective(AnalogValue record);

    AnalogValue selectById(Long id);

    int updateByIdSelective(AnalogValue record);

    int updateById(AnalogValue record);

    /**
     * 批量插入部件模拟量值
     *
     * @param list
     * @return
     */
    int insertAll(@Param("list") List<AnalogValue> list);
}