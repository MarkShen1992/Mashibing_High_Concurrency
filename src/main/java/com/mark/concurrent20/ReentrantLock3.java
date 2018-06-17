package com.mark.concurrent20;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
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
 * @author 18009
 *
 */
public class ReentrantLock3 {
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
	
	/**
	 * 使用tryLock进行尝试锁定，不过锁定与否，方法都将继续执行
	 * 可根据tryLock的返回值来确定是否锁定
	 * 也可以指定tryLock的时间，有tryLock(time)抛出异常，所以要注意unlock的处理必须放到finally中
	 */
	synchronized void m2() {
		// 如果锁定了怎么办， 没锁定怎么办， 逻辑根据返回值来判断
		/*boolean locked = lock.tryLock();
		System.out.println("m2......" + locked);
		if (locked) lock.unlock();*/
		
		boolean locked = lock.tryLock();
		try {
			locked = lock.tryLock(5, TimeUnit.SECONDS);
			System.out.println("m2......" + locked);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (locked) lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		ReentrantLock3 r1 = new ReentrantLock3();
		new Thread(r1::m1).start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(r1::m2).start();
	}
}