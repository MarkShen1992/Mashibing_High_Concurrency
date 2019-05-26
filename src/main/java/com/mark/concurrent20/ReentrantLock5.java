package com.mark.concurrent20;

import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock用于代替synchronized
 * 本例中由于m1锁定this, 只有m1执行完毕的时候， m2才能执行
 * 这里是复制synchronized最原始的语义
 * 
 * 使用reentrantlock可以完成相同的功能
 * 需要注意的是，必须要必须要必须要手动释放锁
 * 使用synchronized锁定的话如果遇到异常，JVM会自动释放锁，但是lock必须手动释放锁， 因此经常在finally中进行锁的释放
 * 
 * 使用reentrantlock可以进行尝试锁定"tryLock", 这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 * 
 * 使用reentrantlock可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程中等待锁的过程中， 可能被打断
 * 
 * reentrantlock还可以指定为公平锁，默认的synchronized为非公平锁
 * 谁等的时间长，谁获得锁
 * 
 * @author 18009
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