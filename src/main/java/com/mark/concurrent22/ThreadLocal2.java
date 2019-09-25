package com.mark.concurrent22;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal线程局部变量
 * 空间换时间，synchronized时间换空间
 * 比如Hibernate中session就是存放在ThreadLocal中的， 避免synchronized的使用。
 * 
 * 运行下面程序，理解ThreadLocal
 * 在使用的时候，状态改变，自己维护这个状态，不用通知其他线程，这时使用ThreadLocal
 * 可能会导致内存泄漏
 *
 * 使用场景：自己进行改变，自己维护这个状态，不用其他线程
 * https://blog.csdn.net/zsfsoftware/article/details/50933151
 * @author MarkShen
 *
 */
public class ThreadLocal2 {
	// 每个线程各放一份，修改只改自己的一份， 不会是别人的一份，以空间换时间，效率更高
	static ThreadLocal<Person> tl = new ThreadLocal<>();
	public static void main(String[] args) {
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(tl.get());
		}).start();
		
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			tl.set(new Person());
		}).start();
	}
	
	static class Person {
		String name = "zhangsan";
	}
}