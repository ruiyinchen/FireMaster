package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.ConfFacilitySys;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ConfFacilitySysDao {
    int deleteById(Long id);

    int insert(ConfFacilitySys record);

    int insertSelective(ConfFacilitySys record);

    ConfFacilitySys selectById(Long id);

    /**
     * 批量插入建筑消防设施系统配置信息
     * @param list
     * @return
     */
    int insertAll(List<ConfFacilitySys> list);
}