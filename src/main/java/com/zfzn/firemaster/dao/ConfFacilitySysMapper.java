package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.ConfFacilitySys;

public interface ConfFacilitySysMapper {
    int deleteById(Long id);

    int insert(ConfFacilitySys record);

    int insertSelective(ConfFacilitySys record);

    ConfFacilitySys selectById(Long id);

    int updateByIdSelective(ConfFacilitySys record);

    int updateById(ConfFacilitySys record);
}