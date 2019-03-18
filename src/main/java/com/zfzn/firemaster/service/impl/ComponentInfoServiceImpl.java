package com.zfzn.firemaster.service.impl;

import com.github.pagehelper.PageHelper;
import com.zfzn.firemaster.dao.AnalogValueDao;
import com.zfzn.firemaster.dao.StatusRecordComponentDao;
import com.zfzn.firemaster.domain.od.AnalogValue;
import com.zfzn.firemaster.domain.od.StatusRecordComponent;
import com.zfzn.firemaster.domain.ov.PageRequest;
import com.zfzn.firemaster.domain.ov.Result;
import com.zfzn.firemaster.domain.ov.ResultEnum;
import com.zfzn.firemaster.service.ComponentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 部件状态信息业务接口实现
 *
 * @author : Tony.fuxudong
 * Created in 7:31 2019/3/18
 */
@Service
public class ComponentInfoServiceImpl implements ComponentInfoService {
    private final StatusRecordComponentDao statusRecordComponentDao;
    private final AnalogValueDao analogValueDao;

    @Autowired
    public ComponentInfoServiceImpl(StatusRecordComponentDao statusRecordComponentDao, AnalogValueDao analogValueDao) {
        this.statusRecordComponentDao = statusRecordComponentDao;
        this.analogValueDao = analogValueDao;
    }

    @Override
    public Result queryStatus(PageRequest<Integer> query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<StatusRecordComponent> list = statusRecordComponentDao.selectByAddrCode(query.getParameter());
        return list.size() > 0 ? Result.success(list) : Result.newInstance(ResultEnum.NO_RESULT, "无数据!");
    }

    @Override
    public Result queryValue(Integer addrCode) {
        AnalogValue value=analogValueDao.selectByAddrCode(addrCode);
        return value!=null?Result.success(value):Result.newInstance(ResultEnum.NO_RESULT,"无数据!");
    }
}
