package com.mark.concurrent19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 曾经的面试题(淘宝?)
 * 实现一个程序，提供两个方法， add, size
 * 写两个线程，线程一添加10个元素到容器中，线程2实现监控线程的个数，
 * 当个数到5个时，线程2给出提示并结束
 * 
 * 添加volatile，使t2可以得到通知， 但是，t2线程的死循环很浪费CPU, 如果不用死循环该怎么做？
 * 面试题要比你的竞争者好， 比别人牛
 * 怎么展现自己（重要）
 * 
 * 这里使用wait和notify做到， wait会释放锁， 而notify不会释放锁(被锁定对象的wait和notify方法)
 * 需要注意的是，运用这种方法，必须保证t2先执行，先让t2监听才可以
 * 
 * 阅读线面程序给出结果
 * 可以读到输出结果并不是size==5时， t2退出， 而是t1结束时通知t2才收到通知而退出
 * 想想为什么？？？
 * notify不会释放锁， sleep也不释放锁
 * 
 * notify之后，t1必须释放锁， t2退出后，也必须notify, 通知t1继续执行， 整个通信过程比较繁琐
 * 
 * 使用Latch（门闩）代替wait, notify来进行通知
 * 好处通信方式简单， 同时可以指定等待时间
 * 使用await和countdown方法来代替wait, notify
 * CountDownLatch不涉及锁定，当count的值为0时当前线程继续运行
 * 当不涉及同步，只有涉及线程通信的时候，用synchronized + wait/notify就太重了
 * 这时应该考虑使用CountDownLatch/cyclicbarrier/semaphore
 * 
 * @author MarkShen
 *
 */
public class MyContainer5 {
	
	// 添加volatile，使t2可以得到通知
	volatile List list = new ArrayList();
	
	public void add(Object o) {
		list.add(o);
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		MyContainer5 c = new MyContainer5();
		
		CountDownLatch latch = new CountDownLatch(1);
		
		new Thread(() -> {
			System.out.println("t2 启动");
			if (c.size() != 5) {
				try {
					latch.await();
					// 可以指定等待时间
					// latch.await(5000, TimeUnit.MILLISECONDS)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("t2 结束");
		}, "2").start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(() -> {
			for (int i=0; i<10; i++) {
				c.add(new Object());
				System.out.println("add " + i);
				
				if (c.size() == 5) {
					// 打开门闩，让t2得以执行
					latch.countDown();
				}
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t1").start();
	}
}