package com.zfzn.firemaster.service;

import com.zfzn.firemaster.domain.ov.PageRequest;
import com.zfzn.firemaster.domain.ov.Result;

/**
 * 部件状态信息业务接口定义
 *
 * @author : Tony.fuxudong
 * Created in 7:29 2019/3/18
 */
public interface ComponentInfoService {
    /**
     * 查询部件状态
     *
     * @param query
     * @return
     */
    Result queryStatus(PageRequest<Integer> query);

    /**
     * 查询部件模拟量值
     *
     * @param addrCode
     * @return
     */
    Result queryValue(Integer addrCode);
}
