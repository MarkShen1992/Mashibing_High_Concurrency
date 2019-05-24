package com.mark.concurrent02;

/**
 * synchronized 对对象加锁
 * @author 18009
 *
 */
public class T2 implements Runnable {

	private static int count = 10;

	@Override
	public void run() {
		// lock current object.
		synchronized(T2.class) { // 任何线程要执行下面的代码， 必须先拿到this的锁, 锁定this对象, 锁对象， 而不是代码块
			count --;
			System.out.println(Thread.currentThread().getName() + "" + count);
		}
	}

	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			new Thread(new T2(), "thread" + i + "-").start();
		}
	}

}
