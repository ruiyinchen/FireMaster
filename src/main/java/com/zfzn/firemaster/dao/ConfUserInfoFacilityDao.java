package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.ConfUserInfoFacility;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConfUserInfoFacilityDao {
    int deleteById(Long id);

    int insert(ConfUserInfoFacility record);

    int insertSelective(ConfUserInfoFacility record);

    ConfUserInfoFacility selectById(Long id);

    /**
     * 批量插入用户传输装置配置信息
     * @param list
     * @return
     */
    int insertAll(List<ConfUserInfoFacility> list);
}