package com.mark.concurrent01;

/**
 * synchronized 对对象加锁
 * @author MarkShen
 *
 */
public class T {

	private int count = 10;
	private Object o = new Object();
	
	public void m() {
		synchronized(o) { // 任何线程要执行下面的代码， 必须先拿到o的锁
			count --;
			System.out.println(Thread.currentThread().getName() + "" + count);
		}
	}
}
