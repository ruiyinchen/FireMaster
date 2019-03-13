package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.StatusRecordSystemMapper;
import com.zfzn.firemaster.domain.od.StatusRecordSystem;
import com.zfzn.firemaster.domain.up.FireFacilitySystemStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 系统状态记录DAO 复用层
 *
 * @author : Tony.fuxudong
 * Created in 19:27 2019/3/13
 */
@Component
public class StatusRecordSystemManager {
    private final Logger _logger = LoggerFactory.getLogger(StatusRecordComponentManager.class);

    private final StatusRecordSystemMapper statusRecordSystemMapper;

    @Autowired
    public StatusRecordSystemManager(StatusRecordSystemMapper statusRecordSystemMapper) {
        this.statusRecordSystemMapper = statusRecordSystemMapper;
    }

    public int saveAll(List<Object> fssList) {
        List<StatusRecordSystem> list = fssList.stream()
                .map(item -> {
                    FireFacilitySystemStatus fss = (FireFacilitySystemStatus) item;
                    StatusRecordSystem srs = new StatusRecordSystem();
                    // TODO 待补充类型转化代码
                    return srs;
                }).collect(Collectors.toList());
        int n=statusRecordSystemMapper.insertAll(list);
        _logger.info("存储系统状态信息，影响行："+n);
        return n;
    }
}
