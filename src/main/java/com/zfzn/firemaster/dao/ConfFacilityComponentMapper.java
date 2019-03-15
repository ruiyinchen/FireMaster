package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.ConfFacilityComponent;

public interface ConfFacilityComponentMapper {

    int deleteById(Long id);

    int insert(ConfFacilityComponent record);

    int insertSelective(ConfFacilityComponent record);

    ConfFacilityComponent selectById(Long id);

    int updateByIdSelective(ConfFacilityComponent record);

    int updateById(ConfFacilityComponent record);
}