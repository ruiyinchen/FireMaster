package com.zfzn.firemaster.manager;

import com.alibaba.fastjson.JSON;
import com.zfzn.firemaster.dao.InfoComponentMapper;
import com.zfzn.firemaster.dao.StatusRecordComponentMapper;
import com.zfzn.firemaster.dao.StatusRecordSystemMapper;
import com.zfzn.firemaster.domain.AppDataUnit;
import com.zfzn.firemaster.domain.od.InfoComponent;
import com.zfzn.firemaster.domain.up.FireFacilityComponent;
import com.zfzn.firemaster.domain.up.FireFacilityComponentStatus;
import com.zfzn.firemaster.domain.up.FireFacilityComponentValue;
import com.zfzn.firemaster.factory.up.*;
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
            case DATA_TYPE_UP_FIRE_DEVICE_OPERATIONAL_INFO:
                _logger.info("消防设施操作信息："+ JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_SOFTWARE_VERSION:
                _logger.info("消防设施软件版本："+ JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_SYS_CONFIG:
                _logger.info("消防设施系统配置："+ JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_UNIT_CONFIG:
                _logger.info("消防设施部件配置："+ JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_USER_DEVICE_RUN_STATUS:
                // TODO 待存储
                _logger.info("用户信息传输装置运行状态："+ JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_USER_DEVICE_OPERATIONAL_INFO:
                _logger.info("用户信息传输装置操作信息："+ JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_USER_DEVICE_SOFTWARE_VERSION:
                _logger.info("用户信息传输装置软件版本："+ JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_USER_DEVICE_CONFIG:
                _logger.info("用户信息传输装置配置："+ JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_SYSTEM_TIME:
                _logger.info("建筑消防设施系统时间："+ JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_USER_DEVICE_SWITCH_STATUS:
                _logger.info("用户信息传输装置开关量状态："+ JSON.toJSONString(dataUnit));
                break;
            case DATE_TYPE_UP_GAS_EXTINGUISHING_SYSTEM_STATUS:
                _logger.info("气体灭火系统状态信息："+ JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_USER_DEVICE_SYS_TIME:
                _logger.info("用户信息传输装置系统时间："+ JSON.toJSONString(dataUnit));
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
        infoC.setComponentAddr(component.getAddrCode());
        return infoC;
    }
}
