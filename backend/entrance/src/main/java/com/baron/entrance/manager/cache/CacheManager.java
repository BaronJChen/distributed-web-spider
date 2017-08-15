package com.baron.entrance.manager.cache;

public interface CacheManager {
    <T> T get(Object key);
    void put(Object key, Object value);
}
