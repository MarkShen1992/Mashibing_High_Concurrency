package com.mark.concurrent23;

/**
 * 线程安全的单利模式
 * 最理想的单利模式实现方法
 * @author 18009
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
}