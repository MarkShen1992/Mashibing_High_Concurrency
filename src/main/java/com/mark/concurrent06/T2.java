package com.mark.concurrent06;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * synchronized AtomicInteger
 * @author MarkShen
 */
public class T2 implements Runnable {

	private static AtomicInteger count = new AtomicInteger(10);  // 原子操作，不会出现同样结果

	@Override
	public void run() { // 等同于synchronized(com.mark.concurrent06.T.class)， 原子操作
		int andDecrement = count.getAndDecrement();
		System.out.println(Thread.currentThread().getName() + " count= " + andDecrement);
	}
	
	public static void main(String[] args) {
		T2 t = new T2();
		for (int i = 0; i < 5; i++) {
			new Thread(t, "Thread" + i).start();
		}
	}
}
