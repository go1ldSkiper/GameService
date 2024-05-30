package com.example.gameinfoservice.cache;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/** The type Cache manager. */
@Service
public class CacheManager {
  private static final int MAX_SIZE = 2;
  private final Map<String, Object> cache =
      new LinkedHashMap<>(MAX_SIZE, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(final Map.Entry<String, Object> eldest) {
          return size() > MAX_SIZE;
        }
      };

  /**
   * Put.
   *
   * @param key the key
   * @param value the value
   */
  public void put(final String key, final Object value) {
    cache.put(key, value);
  }

  /**
   * Get object.
   *
   * @param key the key
   * @return the object
   */
  public Object get(final String key) {
    return cache.get(key);
  }

  /**
   * Contains key boolean.
   *
   * @param key the key
   * @return the boolean
   */
  public boolean containsKey(final String key) {
    return cache.containsKey(key);
  }

  /**
   * Remove.
   *
   * @param key the key
   */
  public void remove(final String key) {
    cache.remove(key);
  }

  /** Clear. */
  public void clear() {
    cache.clear();
  }
}
