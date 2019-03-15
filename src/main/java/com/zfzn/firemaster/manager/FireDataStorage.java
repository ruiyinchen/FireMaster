package com.zfzn.firemaster.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zfzn.firemaster.dao.InfoComponentDao;
import com.zfzn.firemaster.dao.StatusRecordComponentDao;
import com.zfzn.firemaster.dao.StatusRecordSystemDao;
import com.zfzn.firemaster.domain.AppDataUnit;
import com.zfzn.firemaster.domain.od.InfoComponent;
import com.zfzn.firemaster.domain.up.FireFacilityComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
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

    private final AnalogValueManager analogValueManager;
    private final StatusRecordComponentManager statusRecordComponentManager;
    private final InfoComponentManager infoComponentManager;
    private final StatusRecordSystemManager statusRecordSystemManager;
    private final OperationRecordFacilityManager operationRecordFacilityManager;
    private final SoftwareVersionFacilityManager softwareVersionFacilityManager;
    private final ConfFacilitySysManager confFacilitySysManager;
    private final ConfFacilityComponentManager confFacilityComponentManager;
    private final StatusRecordUserInfoFacilityManager statusRecordUserInfoFacilityManager;
    private final OperationRecordUserInfoFacilityManager operationRecordUserInfoFacilityManager;
    private final SoftwareVersionUserInfoFacilityManager softwareVersionUserInfoFacilityManager;
    private final ConfUserInfoFacilityManager confUserInfoFacilityManager;
    private final RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    public FireDataStorage(AnalogValueManager analogValueManager, StatusRecordComponentManager statusRecordComponentManager, InfoComponentDao infoComponentDao, StatusRecordComponentDao statusRecordComponentDao, StatusRecordSystemDao statusRecordSystemDao, InfoComponentManager infoComponentManager, StatusRecordSystemManager statusRecordSystemManager, OperationRecordFacilityManager operationRecordFacilityManager, SoftwareVersionFacilityManager softwareVersionFacilityManager, ConfFacilitySysManager confFacilitySysManager, ConfFacilityComponentManager confFacilityComponentManager, StatusRecordUserInfoFacilityManager statusRecordUserInfoFacilityManager, OperationRecordUserInfoFacilityManager operationRecordUserInfoFacilityManager, SoftwareVersionUserInfoFacilityManager softwareVersionUserInfoFacilityManager, ConfUserInfoFacilityManager confUserInfoFacilityManager, RedisTemplate<String, Serializable> redisTemplate) {
        this.analogValueManager = analogValueManager;
        this.statusRecordComponentManager = statusRecordComponentManager;
        this.infoComponentManager = infoComponentManager;
        this.statusRecordSystemManager = statusRecordSystemManager;
        this.operationRecordFacilityManager = operationRecordFacilityManager;
        this.softwareVersionFacilityManager = softwareVersionFacilityManager;
        this.confFacilitySysManager = confFacilitySysManager;
        this.confFacilityComponentManager = confFacilityComponentManager;
        this.statusRecordUserInfoFacilityManager = statusRecordUserInfoFacilityManager;
        this.operationRecordUserInfoFacilityManager = operationRecordUserInfoFacilityManager;
        this.softwareVersionUserInfoFacilityManager = softwareVersionUserInfoFacilityManager;
        this.confUserInfoFacilityManager = confUserInfoFacilityManager;
        this.redisTemplate = redisTemplate;
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
                operationRecordFacilityManager.saveAll(dataUnit.getList());
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_SOFTWARE_VERSION:
                softwareVersionFacilityManager.saveAll(dataUnit.getList());
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_SYS_CONFIG:
                confFacilitySysManager.saveAll(dataUnit.getList());
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_UNIT_CONFIG:
                confFacilityComponentManager.saveAll(dataUnit.getList());
                break;
            case DATA_TYPE_UP_USER_DEVICE_RUN_STATUS:
                statusRecordUserInfoFacilityManager.saveAll(dataUnit.getList());
                break;
            case DATA_TYPE_UP_USER_DEVICE_OPERATIONAL_INFO:
                operationRecordUserInfoFacilityManager.saveAll(dataUnit.getList());
                break;
            case DATA_TYPE_UP_USER_DEVICE_SOFTWARE_VERSION:
                softwareVersionUserInfoFacilityManager.saveAll(dataUnit.getList());
                break;
            case DATA_TYPE_UP_USER_DEVICE_CONFIG:
                confUserInfoFacilityManager.saveAll(dataUnit.getList());
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_SYSTEM_TIME:
                _logger.info("建筑消防设施系统时间：" + JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_USER_DEVICE_SWITCH_STATUS:
                _logger.info("用户信息传输装置开关量状态：" + JSON.toJSONString(dataUnit));
                break;
            case DATE_TYPE_UP_GAS_EXTINGUISHING_SYSTEM_STATUS:
                _logger.info("气体灭火系统状态信息：" + JSON.toJSONString(dataUnit));
                break;
            case DATA_TYPE_UP_USER_DEVICE_SYS_TIME:
                _logger.info("用户信息传输装置系统时间：" + JSON.toJSONString(dataUnit));
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
