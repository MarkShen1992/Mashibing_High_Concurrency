package com.mark.concurrent10;

import java.util.concurrent.TimeUnit;

/**
 * 这里是继承中可能发生的情形，子类调用父类的同步方法， 锁定同一对象
 * @author MarkShen
 */
public class T {
	synchronized void m1() {
		System.out.println("m1 start...");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m1 end...");
	}
	
	public static void main(String[] args) {
		new TT().m1();
	}
}

class TT extends T {
	@Override
	synchronized void m1() {
		System.out.println("child m1 start...");
		super.m1();
		System.out.println("child m1 end...");
	}
}
