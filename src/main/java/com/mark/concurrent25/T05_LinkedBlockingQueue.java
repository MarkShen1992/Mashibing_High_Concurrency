package com.mark.concurrent25;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 非常常用
 * @author MarkShen
 */
public class T05_LinkedBlockingQueue {
	static BlockingQueue<String> strs = new LinkedBlockingQueue<>();  // 非常常用， 无界队列
	
	static Random r = new Random();
	
	public static void main(String[] args) {
		new Thread(() -> {
			for (int i=0; i<100; i++) {
				try {
					strs.put("a" + i);  // 如果满了，等会儿
					TimeUnit.MICROSECONDS.sleep(r.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}, "p1").start();
		
		for (int i = 0; i < 5; i ++) {
			new Thread(() -> {
				for (;;) {
					try {
						System.out.println(Thread.currentThread().getName() + " take - " + strs.take());  // 如果空了，等待
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}			
			}, "c1").start();
		}
	}
}