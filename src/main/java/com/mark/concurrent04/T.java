package com.mark.concurrent04;

/**
 * synchronized
 * 对对象加锁
 * @author MarkShen
 */
public class T {

	private static int count = 10;
	
	public synchronized static void m() { // 等同于synchronized(com.mark.concurrent04.T.class)
		count --;
		System.out.println(Thread.currentThread().getName() + "" + count);
	}
	
	public static void mm() {
		synchronized (T.class) { // 考虑下，这里写synchronized(this)是否可以？ 不可以， 因为静态方法，变量是不需要new出对象就可以访问的
			count --;
		}
	}
}
