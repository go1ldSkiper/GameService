package com.example.gameinfoservice.cache;

import java.util.HashMap;
import org.springframework.stereotype.Service;


/** The type Cache manager. */
@Service
public class CacheManager {
<<<<<<< HEAD
    private final HashMap<String, Object> cache = new HashMap<>();

    /**
     * Put.
     *
     * @param key the key
     * @param value the value
     */
    public void put(final String key, final Object value) {
        cache.put(key, value);
    }
=======
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
>>>>>>> f08aa90c8e02269b92c74c98a24117acd783481a

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

<<<<<<< HEAD
    /** Clear. */
    public void clear() {
        cache.clear();
    }
=======
  /** Clear. */
  public void clear() {
    cache.clear();
  }
>>>>>>> f08aa90c8e02269b92c74c98a24117acd783481a
}
