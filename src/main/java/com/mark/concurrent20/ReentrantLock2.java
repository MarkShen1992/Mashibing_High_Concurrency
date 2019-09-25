package com.mark.concurrent20;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用reentrantlock可以完成相同的功能
 * 需要注意的是，必须要必须要必须要手动释放锁
 * 使用synchronized锁定的话如果遇到异常，JVM会自动释放锁，但是lock必须手动释放锁，
 * 因此经常在finally中进行锁的释放
 * @author MarkShen
 */
public class ReentrantLock2 {
	Lock lock = new ReentrantLock();
	void m1() {
		lock.lock();  // synchronized(this)
		try {
			for (int i = 0; i < 10; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(i);
			}
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
	void m2() {
		lock.lock();
		System.out.println("m2......");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		ReentrantLock2 r1 = new ReentrantLock2();
		new Thread(r1::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(r1::m2).start();
	}
}