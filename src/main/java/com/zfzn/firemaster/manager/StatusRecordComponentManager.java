package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.InfoComponentMapper;
import com.zfzn.firemaster.dao.StatusRecordComponentMapper;
import com.zfzn.firemaster.domain.AppDataUnit;
import com.zfzn.firemaster.domain.od.InfoComponent;
import com.zfzn.firemaster.domain.od.StatusRecordComponent;
import com.zfzn.firemaster.domain.up.FireFacilityComponentStatus;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 部件状态记录DAO复用层
 *
 * @author : Tony.fuxudong
 * Created in 17:25 2019/3/13
 */
@Component
public class StatusRecordComponentManager {
    private final Logger _logger = LoggerFactory.getLogger(StatusRecordComponentManager.class);

    private final SnowflakeIdWorker idWorker = SnowflakeIdWorker.getInstance();
    private final StatusRecordComponentMapper statusRecordComponentMapper;
    private final InfoComponentManager infoComponentManager;

    @Autowired
    public StatusRecordComponentManager(StatusRecordComponentMapper statusRecordComponentMapper, InfoComponentManager infoComponentManager) {
        this.statusRecordComponentMapper = statusRecordComponentMapper;
        this.infoComponentManager = infoComponentManager;
    }

    public int saveAll(List<Object> srcList) {
        List<StatusRecordComponent> list = srcList.stream()
                .map(item -> {
                    FireFacilityComponentStatus fcs = (FireFacilityComponentStatus) item;
                    StatusRecordComponent src = new StatusRecordComponent();
                    src.setId(idWorker.nextId());
                    // TODO 此处需要将区位号转化为地址码
                    src.setAddrCode(fcs.getPartArea());
                    src.setExplanation(fcs.getPartLegend());
                    src.setGmtCreate(fcs.getTriggerTime());

                    byte[] bytes=fcs.getStatus();

                    return src;
                })
                .collect(Collectors.toList());
        int n = statusRecordComponentMapper.insertAll(list);
        _logger.info("存储部件状态信息，影响行数：" + n);
        return n;
    }

}
