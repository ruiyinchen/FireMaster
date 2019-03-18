package com.zfzn.firemaster.service.impl;

import com.github.pagehelper.PageHelper;
import com.zfzn.firemaster.dao.StatusRecordSystemDao;
import com.zfzn.firemaster.domain.od.StatusRecordSystem;
import com.zfzn.firemaster.domain.ov.PageRequest;
import com.zfzn.firemaster.domain.ov.Result;
import com.zfzn.firemaster.domain.ov.ResultEnum;
import com.zfzn.firemaster.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统相关业务实现
 *
 * @author : Tony.fuxudong
 * Created in 7:57 2019/3/18
 */
@Service
public class SystemInfoServiceImpl implements SystemInfoService {
    private final StatusRecordSystemDao statusRecordSystemDao;

    @Autowired
    public SystemInfoServiceImpl(StatusRecordSystemDao statusRecordSystemDao) {
        this.statusRecordSystemDao = statusRecordSystemDao;
    }

    @Override
    public Result queryStatus(PageRequest<Integer> request) {
        PageHelper.startPage(request.getPageNum(),request.getPageSize());
        List<StatusRecordSystem> list=statusRecordSystemDao.selectBySysAddr(request.getParameter());
        return list.size() > 0 ? Result.success(list) : Result.newInstance(ResultEnum.NO_RESULT, "无数据!");
    }
}
