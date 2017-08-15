package com.baron.entrance.manager.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class DefaultCacheManagerImpl implements CacheManager {
    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Override
    public <T> T get(Object key) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {

    }
}
