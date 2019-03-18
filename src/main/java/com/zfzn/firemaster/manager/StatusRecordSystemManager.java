package com.zfzn.firemaster.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zfzn.firemaster.dao.StatusRecordSystemDao;
import com.zfzn.firemaster.domain.bo.AlarmObject;
import com.zfzn.firemaster.domain.od.StatusRecordSystem;
import com.zfzn.firemaster.domain.up.FireFacilitySystemStatus;
import com.zfzn.firemaster.domain.up.GasExtinguishingSystemStatus;
import com.zfzn.firemaster.server.FireControlChannel;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
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

    private final SnowflakeIdWorker idWorker = SnowflakeIdWorker.getInstance();
    private final StatusRecordSystemDao statusRecordSystemDao;
    private final FireControlChannel controlChannel;

    @Autowired
    public StatusRecordSystemManager(StatusRecordSystemDao statusRecordSystemDao, FireControlChannel controlChannel) {
        this.statusRecordSystemDao = statusRecordSystemDao;
        this.controlChannel = controlChannel;
    }

    public int saveAll(List<Object> fssList) {
        List<StatusRecordSystem> list = fssList.stream()
                .map(item -> {
                    FireFacilitySystemStatus fss = JSON.toJavaObject((JSONObject) item, FireFacilitySystemStatus.class);
                    StatusRecordSystem srs = new StatusRecordSystem();
                    srs.setId(idWorker.nextId());
                    srs.setSysCode(fss.getSystemAddr());
                    srs.setSysType(fss.getSystemType());
                    srs.setGmtCreate(fss.getTriggerTime());

                    byte[]  fssStatus=fss.getStatus();
                    srs.setReset(fssStatus[10]);
                    srs.setDeployChange(fssStatus[11]);
                    srs.setManualStatus(fssStatus[12]);
                    srs.setBusFailure(fssStatus[13]);
                    srs.setBackupPowerFailure(fssStatus[14]);
                    srs.setMainPowerFailure(fssStatus[15]);
                    srs.setDelay(fssStatus[0]);
                    srs.setFeedback(fssStatus[1]);
                    srs.setStarted(fssStatus[2]);
                    srs.setSupervision(fssStatus[3]);
                    srs.setShield(fssStatus[4]);
                    srs.setBreakdown(fssStatus[5]);
                    srs.setFireAlarm(fssStatus[6]);
                    srs.setNormalRun(fssStatus[7]);

                    return srs;
                }).collect(Collectors.toList());

        list.forEach(item-> controlChannel.sendTo(new AlarmObject(2,item)));
        return list.size() > 0 ? statusRecordSystemDao.insertAll(list) : 0;
    }
}
