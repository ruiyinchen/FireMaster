package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.InfoComponentDao;
import com.zfzn.firemaster.domain.od.InfoComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 部件信息DAO复用层
 *
 * @author : Tony.fuxudong
 * Created in 16:26 2019/3/13
 */
@Component
public class InfoComponentManager {
    private final InfoComponentDao infoComponentDao;

    @Autowired
    public InfoComponentManager(InfoComponentDao infoComponentDao) {
        this.infoComponentDao = infoComponentDao;
    }

    public int saveList(List<InfoComponent> componentList){
        List<Integer> dittoList= infoComponentDao.checkDitto(componentList);
        // 过滤重复的部件
        List<InfoComponent> list=componentList.stream()
                .filter(item->!dittoList.contains(item.getComponentAddr()))
                .collect(Collectors.toList());
        return list.size()>0? infoComponentDao.insertAll(list):0;
    }
}
