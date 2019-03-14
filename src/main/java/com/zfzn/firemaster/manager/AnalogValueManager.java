package com.zfzn.firemaster.manager;

import com.zfzn.firemaster.dao.AnalogValueMapper;
import com.zfzn.firemaster.domain.AppDataUnit;
import com.zfzn.firemaster.domain.od.AnalogValue;
import com.zfzn.firemaster.domain.od.InfoComponent;
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
    private final AnalogValueMapper analogValueMapper;

    @Autowired
    public AnalogValueManager(AnalogValueMapper analogValueMapper) {
        this.analogValueMapper = analogValueMapper;
    }

    public int saveAll(List<Object> valueList) {
        List<AnalogValue> list = valueList.stream()
                .map(item -> {
                    FireFacilityComponentValue originalValue = (FireFacilityComponentValue) item;
                    AnalogValue value = new AnalogValue();
                    value.setId(idWorker.nextId());
                    value.setAddrCode(originalValue.getAddrCode());
                    value.setAnalogType(originalValue.getValueType());
                    value.setAnalogQuantity(originalValue.getValue());
                    value.setGmtCreate(originalValue.getTriggerTime());
                    return value;
                }).collect(Collectors.toList());
        int m = analogValueMapper.insertAll(list);
        _logger.info("存储部件模拟量值，影响行数：" + m);
        return m;
    }
}
