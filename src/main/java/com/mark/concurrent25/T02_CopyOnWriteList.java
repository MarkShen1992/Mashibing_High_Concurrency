package com.mark.concurrent25;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 写时复制容器 copy on write
 * 多线程下，写效率低， 读效率高
 *
 * 应用场景：适合写少读多的情况
 * 
 * @author MarkShen
 */
public class T02_CopyOnWriteList {
	
	public static void main(String[] args) {
		List<String> lists = 
							// new ArrayList<>(); // 会有并发问题
							// new Vector<>();
							new CopyOnWriteArrayList<>(); // 事件监听器的队列
		Random r = new Random();
		Thread[] threads = new Thread[100];
		
		for (int i=0; i<threads.length; i++) {
			Runnable task = new Runnable() {
				
				@Override
				public void run() {
					for (int i=0; i<1000; i++)
						lists.add("a" + r.nextInt(10000));
				}
			};
			threads[i] = new Thread(task);
		}
		
		runAndComputeTime(threads);
		System.out.println(lists.size());
	}

	private static void runAndComputeTime(Thread[] threads) {
		long start = System.currentTimeMillis();
		Arrays.asList(threads).forEach(t->t.start());
		Arrays.asList(threads).forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}