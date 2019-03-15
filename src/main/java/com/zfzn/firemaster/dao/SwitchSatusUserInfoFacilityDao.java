package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.SwitchSatusUserInfoFacility;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SwitchSatusUserInfoFacilityDao {

    int deleteById(Long id);

    int insert(SwitchSatusUserInfoFacility record);

    int insertSelective(SwitchSatusUserInfoFacility record);

    SwitchSatusUserInfoFacility selectById(Long id);

    /**
     * 批量插入用户信息传输装置开关量状态
     * @param list
     * @return
     */
    int insertAll(List<SwitchSatusUserInfoFacility> list);
}