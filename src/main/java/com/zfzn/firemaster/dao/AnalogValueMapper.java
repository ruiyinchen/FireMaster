package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.AnalogValue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AnalogValueMapper {

    int deleteById(Long id);

    int insert(AnalogValue record);

    int insertSelective(AnalogValue record);

    AnalogValue selectById(Long id);

    int updateByIdSelective(AnalogValue record);

    int updateById(AnalogValue record);
}