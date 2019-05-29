package com.mark.concurrent19;

import java.util.ArrayList;
import java.util.List;
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
 * @author MarkShen
 *
 */
public class MyContainer2 {
	
	// 添加volatile，使t2可以得到通知
	volatile List list = new ArrayList();
	
	public void add(Object o) {
		list.add(o);
	}
	
	public int size() {
		return list.size();
	}
	
	public static void main(String[] args) {
		MyContainer2 c = new MyContainer2();
		
		new Thread(() -> {
			for(int i=0; i<10; i++) {
				c.add(new Object());
				System.out.println("add" + i);
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "t1").start();
		
		new Thread(() ->{ 
			while(true) {
				if (c.size() == 5) {
					break;
				}
			}
			System.out.println("Thread2 finished...");
		}, "t2").start();
	}
}