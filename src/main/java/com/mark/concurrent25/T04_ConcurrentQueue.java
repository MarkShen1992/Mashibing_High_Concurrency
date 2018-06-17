package com.mark.concurrent25;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author 18009
 *
 */
public class T04_ConcurrentQueue {
	
	public static void main(String[] args) {
		Queue<String> strs = new ConcurrentLinkedQueue<>();  // 无界队列
		
		for (int i=0; i<10; i++) {
			strs.offer("a" + i);
		}
		
		System.out.println(strs);
		
		System.out.println(strs.poll());
		System.out.println(strs.size());
		
		System.out.println(strs.peek());
		System.out.println(strs.size());
		
		// 双端队列
		// 并发容器中常用
	}
}