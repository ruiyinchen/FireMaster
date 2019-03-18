package com.zfzn.firemaster.dao;

import com.zfzn.firemaster.domain.od.AnalogValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnalogValueDao {

    int deleteById(Long id);

    int insert(AnalogValue record);

    int insertSelective(AnalogValue record);

    AnalogValue selectById(Long id);

    /**
     * 批量插入部件模拟量值
     *
     * @param list
     * @return
     */
    int insertAll(@Param("list") List<AnalogValue> list);

    /**
     * 根据部件地址码查询部件模拟量值
     *
     * @param addrCode
     * @return
     */
    AnalogValue selectByAddrCode(@Param("addrCode") Integer addrCode);
}