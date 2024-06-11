package com.example.gameinfoservice.counter;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;

<<<<<<< HEAD

/** The type Request counter. */
@Component
public class RequestCounter {
    private final AtomicInteger count = new AtomicInteger(0);

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count.get();
    }

    /** Increment. */
    public void increment() {
        count.incrementAndGet();
    }

    /** Reset. */
    public void reset() {
        count.set(0);
    }
=======
/** The type Request counter. */
@Component
public class RequestCounter {
  private final AtomicInteger count = new AtomicInteger(0);

  /**
   * Gets count.
   *
   * @return the count
   */
  public int getCount() {
    return count.get();
  }

  /** Increment. */
  public void increment() {
    count.incrementAndGet();
  }

  /** Reset. */
  public void reset() {
    count.set(0);
  }
>>>>>>> f08aa90c8e02269b92c74c98a24117acd783481a
}
