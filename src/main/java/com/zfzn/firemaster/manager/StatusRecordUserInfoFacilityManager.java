package com.zfzn.firemaster.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zfzn.firemaster.dao.StatusRecordUserInfoFacilityDao;
import com.zfzn.firemaster.domain.bo.AlarmObject;
import com.zfzn.firemaster.domain.od.StatusRecordUserInfoFacility;
import com.zfzn.firemaster.domain.up.FireFacilitySystemStatus;
import com.zfzn.firemaster.domain.up.UserInfoFacilityRunStatus;
import com.zfzn.firemaster.server.FireControlChannel;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户传输装置运行状态复用层
 *
 * @author : Tony.fuxudong
 * Created in 14:22 2019/3/15
 */
@Component
public class StatusRecordUserInfoFacilityManager {
    private final SnowflakeIdWorker idWorker=SnowflakeIdWorker.getInstance();
    private final StatusRecordUserInfoFacilityDao statusRecordUserInfoFacilityDao;
    private final FireControlChannel controlChannel;

    @Autowired
    public StatusRecordUserInfoFacilityManager(StatusRecordUserInfoFacilityDao statusRecordUserInfoFacilityDao, FireControlChannel controlChannel) {
        this.statusRecordUserInfoFacilityDao = statusRecordUserInfoFacilityDao;
        this.controlChannel = controlChannel;
    }

    public int saveAll(List<Object> frsList) {
        List<StatusRecordUserInfoFacility> list = frsList.stream()
                .map(item -> {
                    UserInfoFacilityRunStatus frs = JSON.toJavaObject((JSONObject) item, UserInfoFacilityRunStatus.class);
                    StatusRecordUserInfoFacility sru = new StatusRecordUserInfoFacility();
                    sru.setId(idWorker.nextId());
                    byte[] bytes = frs.getStatus();
                    sru.setNormal(bytes[7]);
                    sru.setFireAlarm(bytes[6]);
                    sru.setBreakdown(bytes[5]);
                    sru.setMainPowerFailure(bytes[4]);
                    sru.setBackupPowerFailure(bytes[3]);
                    sru.setChannelFailure(bytes[2]);
                    sru.setConnectionFailure(bytes[1]);
                    sru.setReserved(bytes[0]);

                    sru.setGmtCreate(frs.getTriggerTime());
                    return sru;
                })
                .collect(Collectors.toList());
        // 前端推送
        list.forEach(item-> controlChannel.sendTo(new AlarmObject(1,item)));
        return list.size() > 0 ? statusRecordUserInfoFacilityDao.insertAll(list) : 0;
    }
}
