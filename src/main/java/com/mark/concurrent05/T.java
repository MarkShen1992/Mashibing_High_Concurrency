package com.mark.concurrent05;

/**
 * 分析下输出结果
 * @author MarkShen
 */
public class T implements Runnable {

	private static int count = 10;

	@Override
	public /* synchronized */ void run() { // 等同于synchronized(com.mark.concurrent05.T.class)， 原子操作
		count --;
		System.out.println(Thread.currentThread().getName() + " count= " + count);
	}
	
	public static void main(String[] args) {
		T t = new T();
		for (int i = 0; i < 5; i++) {
			new Thread(t, "Thread" + i).start();
		}
	}
}
