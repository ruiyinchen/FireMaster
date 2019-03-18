package com.zfzn.firemaster.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zfzn.firemaster.dao.OperationRecordUserInfoFacilityDao;
import com.zfzn.firemaster.domain.od.OperationRecordUserInfoFacility;
import com.zfzn.firemaster.domain.up.FireFacilityOperationInfo;
import com.zfzn.firemaster.domain.up.UserInfoFacilityOperationInfo;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息传输装置操作信息复用层
 *
 * @author : Tony.fuxudong
 * Created in 14:33 2019/3/15
 */
@Component
public class OperationRecordUserInfoFacilityManager {
    private final SnowflakeIdWorker idWorker = SnowflakeIdWorker.getInstance();
    private final OperationRecordUserInfoFacilityDao userInfoFacilityDao;

    @Autowired
    public OperationRecordUserInfoFacilityManager(OperationRecordUserInfoFacilityDao userInfoFacilityDao) {
        this.userInfoFacilityDao = userInfoFacilityDao;
    }

    public int saveAll(List<Object> ufoiList) {
        List<OperationRecordUserInfoFacility> list = ufoiList.stream()
                .map(item -> {
                    UserInfoFacilityOperationInfo ufoi =  JSON.toJavaObject((JSONObject) item, UserInfoFacilityOperationInfo.class);
                    OperationRecordUserInfoFacility uif = new OperationRecordUserInfoFacility();
                    byte[] bytes = ufoi.getOperationalSign();
                    uif.setReset(bytes[7]);
                    uif.setSilence(bytes[6]);
                    uif.setManualAlarm(bytes[5]);
                    uif.setEliminateAlarm(bytes[4]);
                    uif.setSelfTest(bytes[3]);
                    uif.setSelfTest(bytes[2]);
                    uif.setTest(bytes[1]);
                    uif.setReserved(bytes[0]);

                    uif.setOperator(ufoi.getOperatorNo());
                    uif.setGmtCreate(ufoi.getTriggerTime());
                    
                    uif.setId(idWorker.nextId());
                    return uif;
                })
                .collect(Collectors.toList());
        return list.size() > 0 ? userInfoFacilityDao.insertAll(list) : 0;
    }
}
