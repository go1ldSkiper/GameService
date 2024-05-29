package com.example.gameinfoservice.cache;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;


@Service
public class CacheManager {
    private static final int MAX_SIZE = 2;
    private final Map<String, Object> cache = new LinkedHashMap<>(MAX_SIZE, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(final Map.Entry<String, Object> eldest) {
            return size() > MAX_SIZE;
        }
    };


    public void put(final String key, final Object value) {
        cache.put(key, value);
    }


    public Object get(final String key) {
        return cache.get(key);
    }


    public boolean containsKey(final String key) {
        return cache.containsKey(key);
    }


    public void remove(final String key) {
        cache.remove(key);
    }


    public void clear() {
        cache.clear();
    }
}

