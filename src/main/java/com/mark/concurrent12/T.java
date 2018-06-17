package com.mark.concurrent12;

import java.util.concurrent.TimeUnit;

/**
 * volatile关键字， 是一个变量在多线程间可见
 * A, B线程都用到一个变量， Java默认是A线程中保留一份copy, 这样如果B线程修改了该变量， 则线程A未必知道。
 * 使用volatile关键字可以使所有线程都会读到变量的修改值
 * 
 * 在下面的代码中， running时存在于对内存的t对象中
 * 当线程t1开通的时候， 会把running值从内存中读到t1线程的工作区，在运行中直接使用这个copy，并不会每次都去
 * 读取内存，这样， 当主线程修改running的值后，t1线程感知不到， 所以不会停止运行。
 * 
 * 使用volatile, 将会强制所有线程都去对内存中读取running的值, 缓存过期通知
 * 
 * 深入理解请阅读：http://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 * 
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题， 也就是说volatile不能代替synchronized
 * 
 * Java线程处理的内存模型， 深入了解《深入Java虚拟机》 JMM
 * JDK 并发容器， 能用volatile的地方，就不要用锁
 * @author 18009
 *
 */
public class T {
	volatile boolean running = true;  // 对比一下有无volatile情况下， 整个程序运行的结果
	void m() {
		System.out.println("m start");
		while(running) {
			
		}
		System.out.println("m end");
	}
	
	public static void main(String[] args) {
		T t = new T();
		new Thread(t::m, "t1").start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t.running = false;
	}
}