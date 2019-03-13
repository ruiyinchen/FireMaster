package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.InfoComponent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InfoComponentMapper {
    int deleteById(Integer id);

    int insert(InfoComponent record);

    int insertSelective(InfoComponent record);

    InfoComponent selectById(Integer id);

    int updateByIdSelective(InfoComponent record);

    int updateById(InfoComponent record);
}