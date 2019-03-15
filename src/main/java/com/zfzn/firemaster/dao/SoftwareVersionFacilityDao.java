package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.SoftwareVersionFacility;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SoftwareVersionFacilityDao {

    int deleteById(Long id);

    int insert(SoftwareVersionFacility record);

    int insertSelective(SoftwareVersionFacility record);

    SoftwareVersionFacility selectById(Long id);

    /**
     * 批量插入建筑消防设施软件版本
     * @param list
     * @return
     */
    int insertAll(List<SoftwareVersionFacility> list);
}