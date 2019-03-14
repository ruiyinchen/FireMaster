package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.InfoComponentMapper;
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
    private final InfoComponentMapper infoComponentMapper;

    @Autowired
    public InfoComponentManager(InfoComponentMapper infoComponentMapper) {
        this.infoComponentMapper = infoComponentMapper;
    }

    public int saveList(List<InfoComponent> componentList){
        List<Integer> dittoList=infoComponentMapper.checkDitto(componentList);
        // 过滤重复的部件
        List<InfoComponent> list=componentList.stream()
                .filter(item->!dittoList.contains(item.getComponentAddr()))
                .collect(Collectors.toList());
        return list.size()>0?infoComponentMapper.insertAll(list):0;
    }
}
