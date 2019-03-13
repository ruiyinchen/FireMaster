package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.InfoComponentMapper;
import com.zfzn.firemaster.dao.StatusRecordComponentMapper;
import com.zfzn.firemaster.dao.StatusRecordSystemMapper;
import com.zfzn.firemaster.domain.AppDataUnit;
import com.zfzn.firemaster.domain.od.InfoComponent;
import com.zfzn.firemaster.domain.up.FireFacilityComponent;
import com.zfzn.firemaster.domain.up.FireFacilityComponentStatus;
import com.zfzn.firemaster.domain.up.FireFacilityComponentValue;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.zfzn.firemaster.util.Constant.*;

/**
 * 数据存储
 *
 * @author : Tony.fuxudong
 * Created in 16:17 2019/3/13
 */
@Component
public class FireDataStorage {
    private final Logger _logger = LoggerFactory.getLogger(FireDataStorage.class);
    private final SnowflakeIdWorker idWorker = SnowflakeIdWorker.getInstance();

    private final AnalogValueManager analogValueManager;
    private final StatusRecordComponentManager statusRecordComponentManager;
    private final InfoComponentManager infoComponentManager;
    private final StatusRecordSystemManager statusRecordSystemManager;

    @Autowired
    public FireDataStorage(AnalogValueManager analogValueManager, StatusRecordComponentManager statusRecordComponentManager, InfoComponentMapper infoComponentMapper, StatusRecordComponentMapper statusRecordComponentMapper, StatusRecordSystemMapper statusRecordSystemMapper, InfoComponentManager infoComponentManager, StatusRecordSystemManager statusRecordSystemManager) {
        this.analogValueManager = analogValueManager;
        this.statusRecordComponentManager = statusRecordComponentManager;
        this.infoComponentManager = infoComponentManager;
        this.statusRecordSystemManager = statusRecordSystemManager;
    }

    public void storage(AppDataUnit dataUnit) {
        switch (dataUnit.getDataType()) {
            case DATA_TYPE_UP_FIRE_DEVICE_SYS_STATUS:
                statusRecordSystemManager.saveAll(dataUnit.getList());
                break;
            case DATA_TYPE_UP_FIRE_UNIT_RUN_STATUS:
                componentStorage(dataUnit);
                statusRecordComponentManager.saveAll(dataUnit.getList());
                break;
            case DATA_TYPE_UP_FIRE_UNIT_VALUE:
                componentStorage(dataUnit);
                analogValueManager.saveAll(dataUnit.getList());
                break;
        }
    }

    public void componentStorage(AppDataUnit dataUnit) {
        if (dataUnit.getList() != null) {
            List<InfoComponent> list = dataUnit.getList()
                    .stream()
                    .map(item -> toInfoComponent((FireFacilityComponent) item))
                    .collect(Collectors.toList());
            if (list.size() > 0) {
                int m = infoComponentManager.saveList(list);
                _logger.info("存储部件信息，影响行数：" + m);
            }
        }
    }

    private InfoComponent toInfoComponent(FireFacilityComponent component) {
        InfoComponent infoC = new InfoComponent();
        infoC.setSysType(component.getSystemType());
        infoC.setSysAddr(component.getSystemAddr());
        infoC.setComponentType(component.getPartType());
        // TODO 此处需要将区位号转化为地址码
        infoC.setComponentAddr(component.getPartArea());
        return infoC;
    }
}
