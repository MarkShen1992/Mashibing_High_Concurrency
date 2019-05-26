package com.mark.concurrent23;

import java.util.Arrays;

/**
 * 线程安全的单利模式
 * 最理想的单利模式实现方法
 * @author MarkShen
 *
 */
public class Singleton {
	private Singleton() {}
	
	private static class Inner {
		private static Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return Inner.instance;
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[200];
		for (int i=0; i<threads.length; i++) {
			threads[i] = new Thread(() -> {
				Singleton.getInstance();
			});
		}

		Arrays.asList(threads).forEach(o -> o.start());
	}
}