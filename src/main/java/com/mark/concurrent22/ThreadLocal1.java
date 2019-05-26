package com.mark.concurrent22;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author MarkShen
 *
 */
public class ThreadLocal1 {
	volatile static Person p = new Person();
	
	public static void main(String[] args) {
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(p.name);
		}).start();
		
		new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			p.name = "lisi";
		}).start();
	}
}

class Person {
	String name = "zhangsan";
}