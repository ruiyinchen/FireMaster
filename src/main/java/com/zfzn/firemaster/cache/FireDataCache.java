package com.zfzn.firemaster.cache;

import java.util.List;

/**
 * 消防数据缓存
 *
 * @author : Tony.fuxudong
 * Created in 17:06 2019/3/6
 */
public interface FireDataCache {
    String GLOBAL_VALUE="global_value";

    void learnGlobal(String key,GlobalValue value);

    List<GlobalValue> readTarget(String key);
}
