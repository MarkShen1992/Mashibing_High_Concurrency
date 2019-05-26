package com.mark.concurrent09;

import java.util.concurrent.TimeUnit;

/**
 * 一个同步方法可以调用另一个同步方法。 一个线程已经某个对象的锁，再次申请的时候任然会得到该对象的锁
 * 也就是说synchronized获得的锁是可重入的
 * @author 18009
 *
 */
public class T {
	synchronized void m1() {
		System.out.println("m1 start...");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		m2();
	}
	
	synchronized void m2() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m2");
	}
}
