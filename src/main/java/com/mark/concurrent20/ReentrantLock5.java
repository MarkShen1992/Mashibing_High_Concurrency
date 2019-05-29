package com.mark.concurrent20;

import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock还可以指定为公平锁，默认的synchronized为非公平锁
 * 谁等的时间长，谁获得锁
 * 
 * @author MarkShen
 *
 */
public class ReentrantLock5 extends Thread {
	
	private ReentrantLock lock = new ReentrantLock(true); // 参数为true为公平锁，请对比输入结果
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName() + "获得锁");
			} finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		ReentrantLock5 r1 = new ReentrantLock5();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
	}
}