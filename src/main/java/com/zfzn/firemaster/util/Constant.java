package com.zfzn.firemaster.util;

/**
 * 系统常量定义
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-11 12:23
 */
public class Constant {
    // 控制单元命令字定义
    /**
     * 保留
     */
    public static final int COMMAND_RESERVED=0;
    /**
     * 控制命令
     */
    public static final int COMMAND_CONTROL=1;
    /**
     * 发送数据
     */
    public static final int COMMAND_SEND_DATA=2;
    /**
     * 确认
     */
    public static final int COMMAND_CONFIRM=3;
    /**
     * 请求
     */
    public static final int COMMAND_REQUEST=4;
    /**
     * 应答
     */
    public static final int COMMAND_ANSWER=5;
    /**
     * 否认
     */
    public static final int COMMAND_DENY=6;

    // 类型标志定义
    /**
     * 预留
     */
    public static final int DATA_TYPE_RESERVED=0;
    /**
     * 上传建筑消防设施系统状态
     */
    public static final int DATA_TYPE_UP_FIRE_DEVICE_SYS_STATUS=1;
    /**
     * 上传建筑消防设施部件运行状态
     */
    public static final int DATA_TYPE_UP_FIRE_UNIT_RUN_STATUS=2;
    /**
     * 上传建筑消防设施部件模拟量值
     */
    public static final int DATA_TYPE_UP_FIRE_UNIT_VALUE=3;
    /**
     * 上传建筑消防设施操作信息
     */
    public static final int DATA_TYPE_UP_FIRE_DEVICE_OPERATIONAL_INFO=4;
    /**
     * 上传建筑消防设施软件版本
     */
    public static final int DATA_TYPE_UP_FIRE_DEVICE_SOFTWARE_VERSION=5;
    /**
     * 上传建筑消防设施系统配置情况
     */
    public static final int DATA_TYPE_UP_FIRE_DEVICE_SYS_CONFIG = 6;
    /**
     * 上传建筑消防设施部件配置情况
     */
    public static final int DATA_TYPE_UP_FIRE_DEVICE_UNIT_CONFIG = 7;
    /**
     * 上传建筑消防设施系统时间
     */
    public static final int DATA_TYPE_UP_FIRE_DEVICE_SYSTEM_TIME = 8;

    // 9-20 预留(建筑消防设施信息)

    /**
     * 上传用户信息传输装置运行状态
     */
    public static final int DATA_TYPE_UP_USER_DEVICE_RUN_STATUS = 21;

    // 22 预留

    // 23 预留

    /**
     * 上传用户信息传输装置操作信息
     */
    public static final int DATA_TYPE_UP_USER_DEVICE_OPERATIONAL_INFO = 24;
    /**
     * 上传用户信息传输装置软件版本
     */
    public static final int DATA_TYPE_UP_USER_DEVICE_SOFTWARE_VERSION = 25;
    /**
     * 上传用户信息传输装置配置情况
     */
    public static final int DATA_TYPE_UP_USER_DEVICE_CONFIG = 26;

    // 27 预留

    /**
     * 上传用户信息传输装置系统时间
     */
    public static final int DATA_TYPE_UP_USER_DEVICE_SYS_TIME = 28;

    // 29～40 预留(用户信息传输装置信息)

    // 41～60 预留(控制信息)

    /**
     * 读建筑消防设施系统状态
     */
    public static final int DATA_TYPE_DOWN_FIRE_DEVICE_SYS_STATUS = 61;
    /**
     * 读建筑消防设施部件运行状态
     */
    public static final int DATA_TYPE_DOWN_FIRE_UNIT_RUN_STATUS = 62;
    /**
     * 读建筑消防设施部件模拟量值
     */
    public static final int DATA_TYPE_DOWN_FIRE_UNIT_VALUE = 63;
    /**
     * 读建筑消防设施操作信息
     */
    public static final int DATA_TYPE_DOWN_FIRE_DEVICE_OPERATIONAL_INFO = 64;
    /**
     * 读建筑消防设施软件版本
     */
    public static final int DATA_TYPE_DOWN_FIRE_DEVICE_SOFTWARE_VERSION = 65;
    /**
     * 读建筑消防设施系统配置情况
     */
    public static final int DATA_TYPE_DOWN_FIRE_DEVICE_SYS_CONFIG = 66;
    /**
     * 读建筑消防设施部件配置情况
     */
    public static final int DATA_TYPE_DOWN_FIRE_UNIT_CONFIG = 67;
    /**
     * 读建筑消防设施系统时间
     */
    public static final int DATA_TYPE_DOWN_FIRE_DEVICE_SYS_TIME = 68;

    //69～80 预留

    /**
     * 读用户信息传输装置运行状态
     */
    public static final int DATA_TYPE_DOWN_USER_DEVICE_RUN_STATUS = 81;

    // 82 预留

    // 83 预留

    /**
     * 读用户信息传输装置操作信息记录
     */
    public static final int DATA_TYPE_DOWN_USER_DEVICE_OPERATIONAL_INFO = 84;
    /**
     * 读用户信息传输装置软件版本
     */
    public static final int DATA_TYPE_DOWN_USER_DEVICE_SOFTWARE_VERSION = 85;
    /**
     * 读用户信息传输装置配置情况
     */
    public static final int DATA_TYPE_DOWN_USER_DEVICE_CONFIG = 86;

    // 87 预留

    /**
     * 读用户信息传输装置系统时间
     */
    public static final int DATA_TYPE_DOWN_USER_DEVICE_SYSTEM_TIME = 88;
    /**
     * 初始化用户信息传输装置
     */
    public static final int DATA_TYPE_DOWN_INIT_USER_DEVICE = 89;
    /**
     * 同步用户信息传输装置时钟
     */
    public static final int DATA_TYPE_DOWN_SYNC_USER_DEVICE_CLOCK = 90;
    /**
     * 查岗命令
     */
    public static final int DATA_TYPE_DOWN_PATROL_COMMAND = 91;

    // 92-127 预留

    // 128-254 用户自定义


}
