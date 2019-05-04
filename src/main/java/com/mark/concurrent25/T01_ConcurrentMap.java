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
 * 	1) 不加锁
 * 	HashMap
 * 	TreeMap
 * 	LinkedHashMap
 * 
 * 	2) 加锁
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
 * 	Collection.synchronizedXXX
 * 	CopyOnWrite
 * 
 * 	高并发场景
 * 	ConcurrentLinkedQueue
 * 	BlockingQueue
 * 		LinkedBlockingQueue
 * 		ArrayBlockingQueue
 * 		TransferQueue
 * 		SynchronousQueue
 * 	DelayQueue：定时任务
 * 
 * @author 18009
 *
 */
public class T01_ConcurrentMap {
	
	public static void main(String[] args) {
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