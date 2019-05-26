package com.mark.concurrent21;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 面试题
 * 写一个固定容量同步容器， 拥有put,get方法，以及getCount方法
 * 能够支持2个生产线程， 10个消费线程的阻塞调用
 * 
 * 使用wait和notify/notifyAll来实现
 * Effective Java: wait 往往与 while一起使用
 * 
 * @author 18009
 *
 */
public class MyContainer1<T> {
	
	final private LinkedList<T> lists = new LinkedList<>();
	final private int MAX = 10; // 最多是个元素
	private int count = 0;
	
	public synchronized void put(T t) {
		while (lists.size() == MAX) { // 为什么要用while， 不用if?
			/**
			 * 两个以上线程的时候
			 */
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		lists.add(t);
		++ count;
		this.notifyAll();  // 通知消费者线程进行消费
	}
	
	public synchronized T get() {
		T t = null;
		while (lists.size() == 0) { // 为什么要用while， 不用if?
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		t = lists.removeFirst();
		-- count;
		this.notifyAll();  // 通知生产者线程进行生产
		return t;
	}
	
	public static void main(String[] args) {
		MyContainer1<String> c = new MyContainer1<String>();
		// start consumer thread
		for (int i = 0; i < 10; i ++) {
			new Thread(() -> {
				for (int j = 0; j < 5; j++) {
					System.out.println(c.get());
				}
			}, "c" + i).start();
		}
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// start producer thread
		for (int i = 0; i < 2; i ++) {
			new Thread(() -> {
				for (int j = 0; j < 25; j++) {
					c.put(Thread.currentThread().getName() + " " + j);
				}
			}, "p" + i).start();
		}
	}
}