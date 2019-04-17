package com.mark.concurrent01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.mark.concurrent01.T;
import junit.framework.TestCase;

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
}
