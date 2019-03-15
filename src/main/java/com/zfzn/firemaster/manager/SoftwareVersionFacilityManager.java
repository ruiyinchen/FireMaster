package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.SoftwareVersionFacilityDao;
import com.zfzn.firemaster.domain.od.SoftwareVersionFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 建组消防设施软件版本复用层
 *
 * @author : Tony.fuxudong
 * Created in 12:23 2019/3/15
 */
@Component
public class SoftwareVersionFacilityManager {
    private final SoftwareVersionFacilityDao versionFacilityDao;

    @Autowired
    public SoftwareVersionFacilityManager(SoftwareVersionFacilityDao versionFacilityDao) {
        this.versionFacilityDao = versionFacilityDao;
    }

    public int saveAll(List<Object> fsvList) {
        List<SoftwareVersionFacility> list=fsvList.stream()
                .map(item->{
                    SoftwareVersionFacility svf=new SoftwareVersionFacility();
                    return svf;
                })
                .collect(Collectors.toList());
        return list.size()>0?versionFacilityDao.insertAll(list):0;
    }
}
