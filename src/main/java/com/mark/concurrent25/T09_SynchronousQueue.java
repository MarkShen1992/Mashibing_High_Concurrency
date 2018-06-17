package com.mark.concurrent25;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 用在更高的并发的情况下，实时消息处理
 * 消费者先起来， 生产者直接找消费者， 如果有消费者，直接把数据给消费者
 * 
 * 1) 先启动消费者线程
 * 2) 先启动生产者线程
 * @author 18009
 *
 */
public class T09_SynchronousQueue {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> strs = new SynchronousQueue<>();  // 没有容量的队列
		
		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		// strs.add("aaa");
		strs.put("aaa");  // 阻塞等待消费者消费
		System.out.println(strs.size());
	}
}