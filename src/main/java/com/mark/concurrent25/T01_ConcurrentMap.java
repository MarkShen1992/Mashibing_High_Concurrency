package com.mark.concurrent25;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * 阅读ConcurrentSkipListMap
 * http://blog.csdn.net/sunxianghuang/article/details/52221913
 *
 * 总结
 * 1. 对于Map/Set的选择与使用
 * 	1) 不加锁（单线程时候）
 * 	HashMap
 * 	TreeMap
 * 	LinkedHashMap
 * 
 * 	2) 加锁（多线程场景）
 * 	并发不高
 * 	Hashtable
 * 	Collections.synchronizedXXX
 * 
 * 	并发高的时候
 * 	ConcurrentHashMap
 * 
 * 	并发性高且排序
 * 	ConcurrentSkipListMap
 * 
 * 2. 队列
 * 	ArrayList
 * 	LinkedList
 * 	Collections.synchronizedXXX
 * 	CopyOnWriteList
 * 
 * 	高并发场景
 * 	ConcurrentLinkedQueue // 非阻塞
 * 	BlockingQueue         // 阻塞
 * 		LinkedBlockingQueue
 * 		ArrayBlockingQueue
 * 		TransferQueue
 * 		SynchronousQueue
 * 	DelayQueue：定时任务
 * 
 * @author MarkShen
 */
public class T01_ConcurrentMap {
	
	public static void main(String[] args) {
		// 不同容器在多线程并发下的效率问题
//		Map<String, String> map = new ConcurrentHashMap<>();
//		Map<String, String> map = new ConcurrentSkipListMap<>();  // 高并发， 排序
		
//		Map<String, String> map = new Hashtable<>();
		Map<String, String> map = new HashMap<String, String>(); // Collections.synchronizedXXX
//		TreeMap
		Random r = new Random();
		Thread[] threads = new Thread[100];
		CountDownLatch latch = new CountDownLatch(threads.length);
		
		long start = System.currentTimeMillis();
		for (int i=0; i<threads.length; i++) {
			threads[i] = new Thread(() -> {
				for (int j=0; j<10000; j++) map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
				latch.countDown();
			});
		}
		
		Arrays.asList(threads).forEach(t->t.start());
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}