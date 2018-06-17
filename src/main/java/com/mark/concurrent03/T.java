package com.mark.concurrent03;

/**
 * synchronized 对对象加锁
 * @author 18009
 *
 */
public class T {

	private int count = 10;
	
	public synchronized void m() { // 等同於 synchronized(this)， 锁定当前对象
		count --;
		System.out.println(Thread.currentThread().getName() + "" + count);
	}
}
