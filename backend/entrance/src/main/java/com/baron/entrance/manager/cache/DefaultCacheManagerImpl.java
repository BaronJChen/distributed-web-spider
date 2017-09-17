package com.baron.entrance.manager.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class DefaultCacheManagerImpl<K, V> implements CacheManager<K, V> {
    @Autowired
    RedisTemplate<K, V> redisTemplate;

    @Override
    public V get(K key) {
        return redisTemplate.boundValueOps(key).get();
    }

    @Override
    public void put(K key, V value) {
        redisTemplate.boundValueOps(key).set(value);
    }
}
