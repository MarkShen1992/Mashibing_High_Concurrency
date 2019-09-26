package com.mark.concurrent26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 刚开始一个线程也没有，来个任务起个线程。如果来个任务，线程池中有空闲的，直接使用空闲的线程。
 * 线程池中空闲线程空闲超过60s后，线程会自动消失。
 * @author MarkShen
 */
public class T08_CachedThreadPool {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newCachedThreadPool();
		System.out.println(service);
		
		for (int i = 0; i < 2; i ++) {
			service.execute(() -> {
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		System.out.println(service);
		
		TimeUnit.SECONDS.sleep(80);
		
		System.out.println(service);

		service.shutdown();
	}
}