package com.mark.concurrent26;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 18009
 *
 */
public class T09_SingleThreadPool {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int i=0; i<5; i++) {
			final int j = i;
			service.execute(() -> {
				System.out.println(j + " " + Thread.currentThread().getName());
			});
		}
	}
}