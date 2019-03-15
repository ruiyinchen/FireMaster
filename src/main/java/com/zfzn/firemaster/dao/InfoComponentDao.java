package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.InfoComponent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InfoComponentDao {
    int deleteById(Integer id);

    int insert(InfoComponent record);

    int insertSelective(InfoComponent record);

    InfoComponent selectById(Integer id);

    /**
     * 检查重复的部件
     * @param list
     * @return
     */
    List<Integer> checkDitto(List<InfoComponent> list);

    /**
     * 批量插入部件信息
     * @param list
     * @return
     */
    int insertAll(@Param("list") List<InfoComponent> list);
}