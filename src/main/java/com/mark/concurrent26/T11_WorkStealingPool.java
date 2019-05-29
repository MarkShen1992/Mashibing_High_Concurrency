package com.mark.concurrent26;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 自己找活干的线程
 * @author MarkShen
 */
public class T11_WorkStealingPool {
	public static void main(String[] args) throws InterruptedException, IOException {
		// 根据CPU有几核启动多少个默认的线程
		// 主动找活儿干; 守护线程，虚拟机不退出，线程不退出。
		ExecutorService service = Executors.newWorkStealingPool();
		System.out.println(Runtime.getRuntime().availableProcessors());  // 8核处理器
		
		service.execute(new R(1000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		service.execute(new R(2000));
		
		// 由于WorkStealingPool是守护线程(Daemon Thread)， 主线程不阻塞，看不到输出
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