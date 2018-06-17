package com.mark.concurrent07;

/**
 * synchronized 对对象加锁, 同步方法和非同步方法是否可以同时调用
 * 在执行m1的过程之中，能否执行m2?
 * 同步方法执行时， 非同步方法可以执行
 * @author 18009
 *
 */
public class T {

	public synchronized void m1() {
		System.out.println(Thread.currentThread().getName() + "m1 start...");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "m1 end...");
	}

	public void m2() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "m2 ...");
	}
	
	public static void main(String[] args) {
		T t = new T();
		
		new Thread(() -> t.m1(), "t1").start();
		new Thread(() -> t.m2(), "t2").start();
		
//		new Thread(t::m1, "t1").start();
//		new Thread(t::m2, "t2").start();
	}
}
