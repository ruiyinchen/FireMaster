package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.en.PackOriginal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PackOriginalDao {

    int deleteById(Long id);

    int insert(PackOriginal record);

    int insertSelective(PackOriginal record);

    PackOriginal selectById(Long id);

    int updateByIdSelective(PackOriginal record);

    int updateById(PackOriginal record);
}