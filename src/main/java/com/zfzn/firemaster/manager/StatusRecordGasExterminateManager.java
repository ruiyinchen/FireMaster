package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.StatusRecordGasExterminateDao;
import com.zfzn.firemaster.domain.od.StatusRecordGasExterminate;
import com.zfzn.firemaster.domain.up.GasExtinguishingSystemStatus;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 气体灭火装置系统状态信息
 *
 * @author : Tony.fuxudong
 * Created in 17:20 2019/3/15
 */
@Component
public class StatusRecordGasExterminateManager {
    private final SnowflakeIdWorker idWorker=SnowflakeIdWorker.getInstance();
    private final StatusRecordGasExterminateDao statusRecordGasExterminateDao;

    @Autowired
    public StatusRecordGasExterminateManager(StatusRecordGasExterminateDao statusRecordGasExterminateDao) {
        this.statusRecordGasExterminateDao = statusRecordGasExterminateDao;
    }

    public int saveAll(List<Object> gesList){
        List<StatusRecordGasExterminate> list=gesList.stream()
                .map(item->{
                    GasExtinguishingSystemStatus ges=(GasExtinguishingSystemStatus)item;
                    StatusRecordGasExterminate sre=new StatusRecordGasExterminate();
                    sre.setId(idWorker.nextId());
                    sre.setSysType(ges.getSystemType());
                    sre.setSysAddr(ges.getSystemAddr());
                    sre.setAreaAddr(ges.getPartAddr());
                    sre.setAlarmType(ges.getAlarmType());
                    sre.setAlarmValue((byte)ges.getAlarmRecovery());
                    sre.setGmtCreate(ges.getTriggerTime());
                    return sre;
                })
                .collect(Collectors.toList());
        return list.size()>0?statusRecordGasExterminateDao.insertAll(list):0;
    }
}
