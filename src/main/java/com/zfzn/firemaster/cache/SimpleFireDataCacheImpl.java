package com.zfzn.firemaster.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 消防数据简单缓存
 *
 * @author : Tony.fuxudong
 * Created in 17:07 2019/3/6
 */
@Component
public class SimpleFireDataCacheImpl implements FireDataCache{
    private final RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    public SimpleFireDataCacheImpl(RedisTemplate<String, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void learnGlobal(String key, GlobalValue value) {
        redisTemplate.opsForHash().put(GLOBAL_VALUE,key,value);
    }
}
