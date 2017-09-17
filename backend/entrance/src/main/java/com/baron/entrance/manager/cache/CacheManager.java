package com.baron.entrance.manager.cache;

public interface CacheManager<K, V> {
    V get(K key);
    void put(K key, V value);
}
