package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.ConfFacilityComponent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConfFacilityComponentDao {

    int deleteById(Long id);

    int insert(ConfFacilityComponent record);

    int insertSelective(ConfFacilityComponent record);

    ConfFacilityComponent selectById(Long id);

    /**
     * 批量插入建筑消防设施部件配置信息
     *
     * @param list
     * @return
     */
    int insertAll(List<ConfFacilityComponent> list);
}