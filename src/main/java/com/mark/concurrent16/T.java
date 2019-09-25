package com.mark.concurrent16;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * synchronized的优化
 * 同步代码中的语句越少越好
 * 比较m1和m2
 * @author MarkShen
 */
public class T {
	
	int count = 0;
	
	synchronized void m1() {
		// do something need not sync
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
		count ++;
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
    void m2() {
		// do something need not sync
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
		// 采用细粒度的锁， 可以使用线程争用时间变短，从而提高效率
		synchronized(this) {
			count ++;
		}
		// do something need not sync
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		T t = new T();
		List<Thread> threads = new ArrayList<Thread>();
		
		for (int i = 0; i < 10; i ++) {
			threads.add(new Thread(t::m1, "thread-" + i));
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