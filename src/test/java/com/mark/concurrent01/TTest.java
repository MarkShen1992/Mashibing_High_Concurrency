package com.mark.concurrent01;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;

/**
 * Unit test for simple App.
 */
public class TTest extends TestCase {
  
  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testM() {
    T t = new T();
    new Thread(() -> t.m(), "t1").start();
    new Thread(() -> t.m(), "t2").start();
  }

  @Test
  public void testDate() {
    // 46546544654.666
    // way 01
    Long currentTime = System.currentTimeMillis();
    String currentTimeWay01 = currentTime / 1000L + "." + currentTime % 1000L;
    System.out.println(currentTimeWay01);

    // way 02
    Instant instant = Instant.now();
    System.out.println(instant);
    System.out.println(instant.getEpochSecond()); // 秒数
    System.out.println(instant.toEpochMilli()); // 毫秒
    System.out.println(System.currentTimeMillis()); // 毫秒
  }
}
