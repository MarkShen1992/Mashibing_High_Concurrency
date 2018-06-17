package com.mark.concurrent21;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试题
 * 写一个固定容量同步容器， 拥有put,get方法，以及getCount方法
 * 能够支持2个生产线程， 10个消费线程的阻塞调用
 * 
 * 使用wait和notify/notifyAll来实现
 * Effective Java: wait 往往与 while一起使用
 * 
 * 使用Lock和Condition来实现
 * 对比两种方式，Condition的方式可以更加精确的指定哪些线程被唤醒
 * 
 * @author 18009
 *
 */
public class MyContainer2<T> {
	
	final private LinkedList<T> lists = new LinkedList<>();
	final private int MAX = 10; // 最多是个元素
	private int count = 0;
	
	private Lock lock = new ReentrantLock();
	private Condition producer = lock.newCondition();
	private Condition consumer = lock.newCondition();
	
	public void put(T t) {
		try {
			lock.lock();
			while (lists.size() == MAX) { // 为什么要用while， 不用if?
				producer.await();
			}
			
			lists.add(t);
			++ count;
			consumer.signalAll();  // 通知消费者线程进行消费
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public T get() {
		T t = null;
		try {
			lock.lock();
			while (lists.size() == 0) { // 为什么要用while， 不用if?
				consumer.await();
			}
			
			t = lists.removeFirst();
			++ count;
			producer.signalAll();  // 通知消费者线程进行消费
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return t;
	}
	
	public static void main(String[] args) {
		MyContainer2<String> c = new MyContainer2<String>();
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