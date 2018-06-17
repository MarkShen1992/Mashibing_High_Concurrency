package com.mark.concurrent26;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 18009
 *
 */
public class T10_SchedulePool {
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
		service.scheduleAtFixedRate(()->{
			try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}, 0, 500, TimeUnit.MILLISECONDS);
	}
}