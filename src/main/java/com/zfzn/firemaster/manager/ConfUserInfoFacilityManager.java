package com.zfzn.firemaster.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zfzn.firemaster.dao.ConfUserInfoFacilityDao;
import com.zfzn.firemaster.domain.od.ConfUserInfoFacility;
import com.zfzn.firemaster.domain.up.FireFacilitySystemConfigInfo;
import com.zfzn.firemaster.domain.up.UserInfoFacilityConfigInfo;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息传输装置配置信息 复用层
 *
 * @author : Tony.fuxudong
 * Created in 15:23 2019/3/15
 */
@Component
public class ConfUserInfoFacilityManager {
    private final SnowflakeIdWorker idWorker = SnowflakeIdWorker.getInstance();
    private final ConfUserInfoFacilityDao confUserInfoFacilityDao;

    @Autowired
    public ConfUserInfoFacilityManager(ConfUserInfoFacilityDao confUserInfoFacilityDao) {
        this.confUserInfoFacilityDao = confUserInfoFacilityDao;
    }

    public int saveAll(List<Object> fciList) {
        List<ConfUserInfoFacility> list = fciList.stream()
                .map(item -> {
                    UserInfoFacilityConfigInfo fci = JSON.toJavaObject((JSONObject) item, UserInfoFacilityConfigInfo.class);
                    ConfUserInfoFacility cuif = new ConfUserInfoFacility();

                    cuif.setDescription(fci.getLegend());
                    cuif.setGmtCreate(fci.getTriggerTime());
                    cuif.setId(idWorker.nextId());

                    return cuif;
                })
                .collect(Collectors.toList());
        return list.size() > 0 ? confUserInfoFacilityDao.insertAll(list) : 0;
    }
}
