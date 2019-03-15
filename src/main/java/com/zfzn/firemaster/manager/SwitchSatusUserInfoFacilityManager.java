package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.SwitchSatusUserInfoFacilityDao;
import com.zfzn.firemaster.domain.od.SwitchSatusUserInfoFacility;
import com.zfzn.firemaster.domain.up.UserInfoFacilitySwitchStatus;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户传输装置开关量状态复用层
 *
 * @author : Tony.fuxudong
 * Created in 17:42 2019/3/15
 */
@Component
public class SwitchSatusUserInfoFacilityManager {
    private final SnowflakeIdWorker idWorker=SnowflakeIdWorker.getInstance();
    private final SwitchSatusUserInfoFacilityDao switchSatusUserInfoFacilityDao;

    @Autowired
    public SwitchSatusUserInfoFacilityManager(SwitchSatusUserInfoFacilityDao switchSatusUserInfoFacilityDao) {
        this.switchSatusUserInfoFacilityDao = switchSatusUserInfoFacilityDao;
    }

    public int saveAll(List<Object> fssList){
        List<SwitchSatusUserInfoFacility> list=fssList.stream()
                .map(item->{
                    UserInfoFacilitySwitchStatus fss=(UserInfoFacilitySwitchStatus)item;
                    SwitchSatusUserInfoFacility suif=new SwitchSatusUserInfoFacility();
                    suif.setId(idWorker.nextId());
                    suif.setLocation(fss.getSwitchPosition());
                    suif.setNormal((byte)fss.getStatus());
                    suif.setSysAddr(fss.getSystemAddr());
                    suif.setGmtCreate(fss.getTriggerTime());
                    return suif;
                })
                .collect(Collectors.toList());
        return list.size()>0?switchSatusUserInfoFacilityDao.insertAll(list):0;
    }
}
