package com.mark.concurrent15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 解决同样的问题更高效的方法，使用AtomicXXX类
 * AtomXXX类本身方法都是原子性的， 但不能保证多方法连续调用的原子性。
 * @author MarkShen
 *
 */
public class T {
	/*volatile int count = 0;*/
	
	AtomicInteger count = new AtomicInteger(0);
	
	/*synchronized*/ void m() {
		for (int i = 0; i < 10000; i++) {
			// if (count.get() < 1000)
			// 这个位置没有原子性
			count.incrementAndGet();
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		List<Thread> threads = new ArrayList<Thread>();
		
		for (int i = 0; i < 10; i ++) {
			threads.add(new Thread(t::m, "thread-" + i));
		}
		
		threads.forEach((o) -> o.start());
		
		threads.forEach((o) -> {
			try {
				o.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println(t.count);
	}
}