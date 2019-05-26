package com.mark.concurrent26;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author MarkShen
 *
 */
public class T11_WorkStealingPool {
	public static void main(String[] args) throws InterruptedException, IOException {
		ExecutorService service = Executors.newWorkStealingPool();
		System.out.println(Runtime.getRuntime().availableProcessors());  // 8核处理器
		
		service.execute(new R(1000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		
		// 由于产生的是守护线程(Daemon Thread)， 主线程不阻塞，看不到输出
		System.in.read();
	}
	
	static class R implements Runnable {

		int time;
		
		public R(int time) {
			this.time = time;
		}

		@Override
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
}