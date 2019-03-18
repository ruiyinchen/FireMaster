package com.zfzn.firemaster.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zfzn.firemaster.dao.StatusRecordComponentDao;
import com.zfzn.firemaster.domain.bo.AlarmObject;
import com.zfzn.firemaster.domain.od.StatusRecordComponent;
import com.zfzn.firemaster.domain.up.FireFacilityComponentStatus;
import com.zfzn.firemaster.domain.up.UserInfoFacilitySoftwareVersion;
import com.zfzn.firemaster.server.FireControlChannel;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private final StatusRecordComponentDao statusRecordComponentDao;
    private final FireControlChannel controlChannel;

    @Autowired
    public StatusRecordComponentManager(StatusRecordComponentDao statusRecordComponentDao, FireControlChannel controlChannel) {
        this.statusRecordComponentDao = statusRecordComponentDao;
        this.controlChannel = controlChannel;
    }

    public int saveAll(List<Object> srcList) {
        List<StatusRecordComponent> list = srcList.stream()
                .map(item -> {
                    FireFacilityComponentStatus fcs = JSON.toJavaObject((JSONObject) item, FireFacilityComponentStatus.class);
                    StatusRecordComponent src = new StatusRecordComponent();
                    src.setId(idWorker.nextId());
                    src.setAddrCode(fcs.getAddrCode());
                    src.setExplanation(fcs.getPartLegend());
                    src.setGmtCreate(fcs.getTriggerTime());

                    byte[] fcsStatus = fcs.getStatus();
                    src.setElectricityFailure(fcsStatus[15]);
                    src.setDelay(fcsStatus[0]);
                    src.setFeedback(fcsStatus[1]);
                    src.setStarted(fcsStatus[2]);
                    src.setSupervision(fcsStatus[3]);
                    src.setShield(fcsStatus[4]);
                    src.setBreakdown(fcsStatus[5]);
                    src.setFireAlarm(fcsStatus[6]);
                    src.setNormalRun(fcsStatus[7]);

                    return src;
                })
                .collect(Collectors.toList());
        // 前端推送
        list.forEach(item-> controlChannel.sendTo(new AlarmObject(3,item)));
        return list.size() > 0 ? statusRecordComponentDao.insertAll(list) : 0;
    }

}
