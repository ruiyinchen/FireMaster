package com.zfzn.firemaster.cache;

import com.zfzn.firemaster.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 消防数据简单缓存
 *
 * @author : Tony.fuxudong
 * Created in 17:07 2019/3/6
 */
@Component
public class SimpleFireDataCacheImpl implements FireDataCache {
    private final RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    public SimpleFireDataCacheImpl(RedisTemplate<String, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void learnGlobal(String key, GlobalValue value) {
        redisTemplate.opsForHash().put(GLOBAL_VALUE, key, value);
    }

    @Override
    public List<GlobalValue> readTarget(String key) {
        return TextUtils.isNotEmpty(key) ? readSingle(key) : readList();
    }

    /**
     * 读取单个目标
     * @param key
     * @return
     */
    private List<GlobalValue> readSingle(String key) {
        return Collections.singletonList((GlobalValue) redisTemplate.opsForHash().get(GLOBAL_VALUE, key));
    }

    /**
     * 读取列表目标
     * @return
     */
    private List<GlobalValue> readList() {
        return redisTemplate.opsForHash()
                .values(GLOBAL_VALUE)
                .stream()
                .map(item -> (GlobalValue) item)
                .collect(Collectors.toList());
    }
}
