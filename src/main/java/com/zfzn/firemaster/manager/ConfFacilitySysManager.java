package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.ConfFacilitySysDao;
import com.zfzn.firemaster.domain.od.ConfFacilitySys;
import com.zfzn.firemaster.domain.up.FireFacilitySystemConfigInfo;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 建组消防设施系统配置复用层
 *
 * @author : Tony.fuxudong
 * Created in 12:40 2019/3/15
 */
@Component
public class ConfFacilitySysManager {
    private final SnowflakeIdWorker idWorker=SnowflakeIdWorker.getInstance();
    private final ConfFacilitySysDao confFacilitySysDao;

    @Autowired
    public ConfFacilitySysManager(ConfFacilitySysDao confFacilitySysDao) {
        this.confFacilitySysDao = confFacilitySysDao;
    }

    public int saveAll(List<Object> fccList){
        List<ConfFacilitySys> list=fccList.stream()
                .map(item->{
                    FireFacilitySystemConfigInfo fsc=(FireFacilitySystemConfigInfo)item;
                    ConfFacilitySys cfs=new ConfFacilitySys();
                    cfs.setId(idWorker.nextId());
                    cfs.setSysType(fsc.getSystemType());
                    cfs.setSysAddr(fsc.getSystemAddr());
                    cfs.setSysDescription(fsc.getLegend());
                    return cfs;
                })
                .collect(Collectors.toList());
        return list.size()>0?confFacilitySysDao.insertAll(list):0;
    }
}
