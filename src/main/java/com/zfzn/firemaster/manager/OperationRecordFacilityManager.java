package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.OperationRecordFacilityDao;
import com.zfzn.firemaster.domain.od.OperationRecordFacility;
import com.zfzn.firemaster.domain.up.FireFacilityOperationInfo;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 消防设施操作记录 复用层
 *
 * @author : Tony.fuxudong
 * Created in 11:48 2019/3/15
 */
@Component
public class OperationRecordFacilityManager {
    private final SnowflakeIdWorker idWorker = SnowflakeIdWorker.getInstance();

    private final OperationRecordFacilityDao recordFacilityDao;

    @Autowired
    public OperationRecordFacilityManager(OperationRecordFacilityDao recordFacilityDao) {
        this.recordFacilityDao = recordFacilityDao;
    }

    public int saveAll(List<Object> foiList) {
        List<OperationRecordFacility> list = foiList.stream()
                .map(item -> {
                    FireFacilityOperationInfo foi = (FireFacilityOperationInfo) item;
                    OperationRecordFacility orf = new OperationRecordFacility();
                    orf.setId(idWorker.nextId());
                    orf.setSysType(foi.getSystemType());
                    orf.setSysAddr(foi.getSystemAddr());
                    orf.setOperator(foi.getOperatorNo());

                    byte[] operational = foi.getOperationalSign();
                    orf.setReserved(operational[0]);
                    orf.setTest(operational[1]);
                    orf.setConfirm(operational[2]);
                    orf.setSelfTest(operational[3]);
                    orf.setEliminateAlarm(operational[4]);
                    orf.setManualAlarm(operational[5]);
                    orf.setSilence(operational[6]);
                    orf.setReset(operational[7]);

                    orf.setGmtCreate(foi.getTriggerTime());
                    return orf;
                })
                .collect(Collectors.toList());
        return list.size() > 0 ? recordFacilityDao.insertAll(list) : 0;
    }
}
