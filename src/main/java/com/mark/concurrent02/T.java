package com.mark.concurrent02;

/**
 * synchronized 对对象加锁
 * @author 18009
 *
 */
public class T {

	private int count = 10;
	
	public void m() {
		synchronized(this) { // 任何线程要执行下面的代码， 必须先拿到this的锁, 锁定this对象, 锁对象， 而不是代码块
			count --;
			System.out.println(Thread.currentThread().getName() + "" + count);
		}
	}
}
