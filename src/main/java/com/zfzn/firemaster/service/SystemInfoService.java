package com.zfzn.firemaster.service;

import com.zfzn.firemaster.domain.ov.PageRequest;
import com.zfzn.firemaster.domain.ov.Result;

/**
 * 系统信息业务接口定义
 *
 * @author : Tony.fuxudong
 * Created in 7:56 2019/3/18
 */
public interface SystemInfoService {
    Result queryStatus(PageRequest<Integer> request);
}
