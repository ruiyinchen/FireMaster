package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.SoftwareVersionUserInfoFacility;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SoftwareVersionUserInfoFacilityDao {

    int deleteById(Long id);

    int insert(SoftwareVersionUserInfoFacility record);

    int insertSelective(SoftwareVersionUserInfoFacility record);

    SoftwareVersionUserInfoFacility selectById(Long id);

    /**
     * 批量插入用户传输装置软件版本信息
     *
     * @param list
     * @return
     */
    int insertAll(List<SoftwareVersionUserInfoFacility> list);
}