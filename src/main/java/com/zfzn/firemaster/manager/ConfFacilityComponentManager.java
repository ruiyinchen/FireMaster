package com.zfzn.firemaster.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zfzn.firemaster.dao.ConfFacilityComponentDao;
import com.zfzn.firemaster.domain.od.ConfFacilityComponent;
import com.zfzn.firemaster.domain.up.FireFacilityComponentConfigInfo;
import com.zfzn.firemaster.domain.up.FireFacilityComponentValue;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 消防建筑设施部件配置复用层
 *
 * @author : Tony.fuxudong
 * Created in 13:51 2019/3/15
 */
@Component
public class ConfFacilityComponentManager {
    private final SnowflakeIdWorker idWorker=SnowflakeIdWorker.getInstance();
    private final ConfFacilityComponentDao confFacilityComponentDao;

    @Autowired
    public ConfFacilityComponentManager(ConfFacilityComponentDao confFacilityComponentDao) {
        this.confFacilityComponentDao = confFacilityComponentDao;
    }

    public int saveAll(List<Object> fccList){
        List<ConfFacilityComponent> list=fccList.stream()
                .map(item->{
                    FireFacilityComponentConfigInfo fcc=JSON.toJavaObject((JSONObject) item, FireFacilityComponentConfigInfo.class);
                    ConfFacilityComponent cfc=new ConfFacilityComponent();
                    cfc.setId(idWorker.nextId());
                    cfc.setAddrCode(fcc.getAddrCode());
                    cfc.setComponentDescription(fcc.getLegend());
                    return cfc;
                })
                .collect(Collectors.toList());
        return list.size()>0?confFacilityComponentDao.insertAll(list):0;
    }
}
