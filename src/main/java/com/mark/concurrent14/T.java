package com.mark.concurrent14;

import java.util.ArrayList;
import java.util.List;

/**
 * 对比上一个程序，可以用synchronized解决， synchronized既保证原子性，又保证可见性；而volatile只保证可见性
 * @author 18009
 *
 */
public class T {
	/*volatile*/ int count = 0;
	void m() {
		for (int i = 0; i < 10000; i++) {
			count ++;
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