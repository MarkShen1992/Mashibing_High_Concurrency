package com.mark.concurrent13;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile	并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能代替synchronized运行下面的程序， 并分析结果。
 * @author 18009
 *
 */
public class T {
	volatile int count = 0;
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