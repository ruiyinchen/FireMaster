package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.SoftwareVersionUserInfoFacilityDao;
import com.zfzn.firemaster.domain.od.SoftwareVersionUserInfoFacility;
import com.zfzn.firemaster.domain.up.UserInfoFacilitySoftwareVersion;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户传输装置软件版本 复用层
 *
 * @author : Tony.fuxudong
 * Created in 15:15 2019/3/15
 */
@Component
public class SoftwareVersionUserInfoFacilityManager {
    private final SnowflakeIdWorker idWorker=SnowflakeIdWorker.getInstance();
    private final SoftwareVersionUserInfoFacilityDao softwareVersionUserInfoFacilityDao;

    @Autowired
    public SoftwareVersionUserInfoFacilityManager(SoftwareVersionUserInfoFacilityDao softwareVersionUserInfoFacilityDao) {
        this.softwareVersionUserInfoFacilityDao = softwareVersionUserInfoFacilityDao;
    }

    public int saveAll(List<Object> usvList) {
        List<SoftwareVersionUserInfoFacility> list = usvList.stream()
                .map(item -> {
                    UserInfoFacilitySoftwareVersion usv = (UserInfoFacilitySoftwareVersion) item;
                    SoftwareVersionUserInfoFacility vuf = new SoftwareVersionUserInfoFacility();
                    vuf.setMainVersion(usv.getMajorVersionNo());
                    vuf.setMinorVersion(usv.getMinorVersionNo());
                    vuf.setGmtCreate(usv.getTriggerTime());
                    vuf.setId(idWorker.nextId());
                    return vuf;
                })
                .collect(Collectors.toList());
        return list.size() > 0 ? softwareVersionUserInfoFacilityDao.insertAll(list) : 0;
    }
}
