package com.zfzn.firemaster.util;

import java.math.BigDecimal;

/**
 * 全局Id生成器
 *
 * @author : Tony.fuxudong
 * Created in 2019-02-03 17:15
 */
public class SnowflakeIdWorker {
    /**
     * 开始时间戳 2019-01-01 00:00:00
     */
    private final long epoch = 1546272000483L;

    /**
     * 机器id所占位数
     */
    private final long machineIdBits = 5L;

    /**
     * 数据标识id所占的位数
     */
    private final long dataCenterIdBits = 5L;

    /**
     * 当前工作机器ID(0~maxMachineId)
     */
    private final long machineId = 8;

    /**
     * 当前数据中心ID(0~maxDataCenterId)
     */
    private final long dataCenterId = 12;

    /**
     * 序列在id中占的位数
     */
    private final long sequenceBits = 12L;

    /**
     * 支持最大的机器id
     */
    private final long maxMachineId = ~(-1L << machineIdBits);

    /**
     * 支持的最大数据标识id
     */
    private final long maxDataCenterId = ~(-1L << dataCenterIdBits);

    /**
     * 机器ID向左移12位
     */
    private final long machineIdShift = sequenceBits;

    /**
     * 数据标识id向左移17位(12+5)
     */
    private final long dataCenterIdShift = sequenceBits + machineIdBits;

    /**
     * 时间截向左移22位(5+5+12)
     */
    private final long timestampLeftShift = sequenceBits + machineIdBits + dataCenterIdBits;

    /**
     * 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095)
     */
    private final long sequenceMask = ~(-1L << sequenceBits);

    /**
     * 毫秒内序列(0~4095)
     */
    private long sequence = 0L;

    /**
     * 上次生成ID的时间截
     */
    private long lastTimestamp = -1L;

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();

        // 若当前时间小于上一次ID生成的时间戳，则系统时钟回退了，抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            // 同一时间生成的，则进行毫秒内序列
            sequence = (sequence + 1) & sequenceMask;
            //毫秒内序列溢出
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = waitNextMillisecond(lastTimestamp);
            }
        } else {
            // 时间戳改变，毫秒内序列重置
            sequence = 0L;
        }

        //上次生成ID的时间截
        lastTimestamp = timestamp;

        //移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - epoch) << timestampLeftShift)
                | (dataCenterId << dataCenterIdShift)
                | (machineId << machineIdShift)
                | sequence;
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    private long waitNextMillisecond(long lastTimestamp) {
        long timestamp;
        do {
            timestamp = System.currentTimeMillis();
        } while (timestamp <= lastTimestamp);
        return timestamp;
    }

    /**
     * 解析id的构成
     *
     * @param id 目标id
     * @return 目标id的组成
     */
    public long[] decryptIdToStr(long id) {
        long sequence = ((new BigDecimal(2)).pow((int) sequenceBits).longValue() - 1) & id;
        long machineId = ((((new BigDecimal(2).pow((int) machineIdBits)).longValue() - 1) << machineIdShift) & id) >> machineIdShift;
        long dataCenterId = ((((new BigDecimal(2).pow((int) dataCenterIdBits)).longValue() - 1) << dataCenterIdShift) & id) >> dataCenterIdShift;
        long timestamp = (id >> timestampLeftShift) + epoch;
        return new long[]{timestamp, dataCenterId, machineId, sequence};
    }

    /**
     * 单例
     *
     * @return 实例
     */
    public static SnowflakeIdWorker getInstance() {
        return SingleTon.singleTon;
    }

    private SnowflakeIdWorker() {
    }

    private static class SingleTon {
        private static final SnowflakeIdWorker singleTon = new SnowflakeIdWorker();
    }
}
