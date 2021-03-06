package com.zfzn.firemaster.factory;

import com.zfzn.firemaster.factory.up.*;

import static com.zfzn.firemaster.util.Constant.*;

/**
 * 信息体分析
 *
 * @author : Tony.fuxudong
 * Created in 14:22 2019/2/28
 */
public class InfoBodyAnalysis {
    /**
     * 创建信息对象解析对象
     *
     * @param dataType 数据类型
     * @return 信息解析对象
     */
    public static ParseObject createAnalysisBody(int dataType) {
        ParseObject parseObject = null;
        switch (dataType) {
            case DATA_TYPE_UP_FIRE_DEVICE_SYS_STATUS:
                parseObject = new FireFacilitySystemStatusParse();
                break;
            case DATA_TYPE_UP_FIRE_UNIT_RUN_STATUS:
                parseObject = new FireFacilityComponentStatusParse();
                break;
            case DATA_TYPE_UP_FIRE_UNIT_VALUE:
                parseObject = new FireFacilityComponentValueParse();
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_OPERATIONAL_INFO:
                parseObject = new FireFacilityOperationInfoParse();
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_SOFTWARE_VERSION:
                parseObject = new FireFacilitySoftwareVersionParse();
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_SYS_CONFIG:
                parseObject = new FireFacilitySystemConfigInfoParse();
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_UNIT_CONFIG:
                parseObject = new FireFacilityComponentConfigInfoParse();
                break;
            case DATA_TYPE_UP_USER_DEVICE_RUN_STATUS:
                parseObject = new UserInfoFacilityRunStatusParse();
                break;
            case DATA_TYPE_UP_USER_DEVICE_OPERATIONAL_INFO:
                parseObject = new UserInfoFacilityOperationInfoParse();
                break;
            case DATA_TYPE_UP_USER_DEVICE_SOFTWARE_VERSION:
                parseObject = new UserInfoFacilitySoftwareVersionParse();
                break;
            case DATA_TYPE_UP_USER_DEVICE_CONFIG:
                parseObject = new UserInfoFacilityConfigInfoParse();
                break;
            case DATA_TYPE_UP_FIRE_DEVICE_SYSTEM_TIME:
                parseObject = new FireFacilitySystemTimeParse();
                break;
            case DATA_TYPE_UP_USER_DEVICE_SWITCH_STATUS:
                parseObject = new UserInfoFacilitySwitchStatusParse();
                break;
            case DATE_TYPE_UP_GAS_EXTINGUISHING_SYSTEM_STATUS:
                parseObject = new GasExtinguishingSystemStatusParse();
                break;
            case DATA_TYPE_UP_USER_DEVICE_SYS_TIME:
                parseObject = new UserInfoFacilitySystemTimeParse();
                break;
        }
        return parseObject;
    }
}
