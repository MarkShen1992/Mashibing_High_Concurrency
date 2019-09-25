package com.mark.concurrent20;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用reentrantlock可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程中等待锁的过程中， 可能被打断
 * 
 * @author MarkShen
 *
 */
public class ReentrantLock4 {
	
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		
		Thread t1 = new Thread(() -> {
			lock.lock();  // synchronized(this)
			try {
				System.out.println("t1 start");
				TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
				System.out.println("t1 end");
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} finally {
				lock.unlock();
			}
		});
		t1.start();
		
		Thread t2 = new Thread(() -> {
			boolean locked = false; // 防止异常抛出
			try {
				// lock.lock();  // synchronized(this)
				lock.lockInterruptibly();  // 可对interrupt()方法做出响应
				// 防止异常抛出
				locked = lock.tryLock();
				System.out.println("t2 start");
				TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
				System.out.println("t2 end");
			} catch (InterruptedException e1) {
				System.out.println("interrupted...");
			} finally {
				if (locked) lock.unlock();
			}
		});
		t2.start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.interrupt(); // Interrupts this thread.
	}
}