package com.zfzn.firemaster.manager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zfzn.firemaster.dao.AnalogValueDao;
import com.zfzn.firemaster.domain.od.AnalogValue;
import com.zfzn.firemaster.domain.up.FireFacilityComponent;
import com.zfzn.firemaster.domain.up.FireFacilityComponentValue;
import com.zfzn.firemaster.util.SnowflakeIdWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 模拟量值DAO　复用层
 *
 * @author : Tony.fuxudong
 * Created in 17:08 2019/3/13
 */
@Component
public class AnalogValueManager {
    private final Logger _logger = LoggerFactory.getLogger(FireDataStorage.class);

    private final SnowflakeIdWorker idWorker = SnowflakeIdWorker.getInstance();
    private final AnalogValueDao analogValueDao;

    @Autowired
    public AnalogValueManager(AnalogValueDao analogValueDao) {
        this.analogValueDao = analogValueDao;
    }

    public int saveAll(List<Object> valueList) {
        List<AnalogValue> list = valueList.stream()
                .map(item -> {
                    FireFacilityComponentValue originalValue = JSON.toJavaObject((JSONObject) item, FireFacilityComponentValue.class);
                    AnalogValue value = new AnalogValue();
                    value.setId(idWorker.nextId());
                    value.setAddrCode(originalValue.getAddrCode());
                    value.setAnalogType(originalValue.getValueType());
                    value.setAnalogQuantity(originalValue.getValue());
                    value.setGmtCreate(originalValue.getTriggerTime());
                    return value;
                }).collect(Collectors.toList());
        int m = analogValueDao.insertAll(list);
        _logger.info("存储部件模拟量值，影响行数：" + m);
        return m;
    }
}
