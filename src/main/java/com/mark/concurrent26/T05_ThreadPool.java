package com.mark.concurrent26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author 18009
 *
 */
public class T05_ThreadPool {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 5; i ++) {
			service.execute(()->{
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		
		System.out.println(service);
		
		service.shutdown();
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
		
		TimeUnit.SECONDS.sleep(5);
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
	}
}