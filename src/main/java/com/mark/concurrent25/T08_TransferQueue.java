package com.mark.concurrent25;

import java.util.concurrent.LinkedTransferQueue;

/**
 * 用在更高的并发的情况下，实时消息处理
 * 消费者先起来， 生产者直接找消费者， 如果有消费者，直接把数据给消费者
 * 
 * 1) 先启动消费者线程
 * 2) 先启动生产者线程
 * @author 18009
 *
 */
public class T08_TransferQueue {

	public static void main(String[] args) throws InterruptedException {
		LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();
		
		new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
		strs.transfer("aaa");
		
//		new Thread(() -> {
//			try {
//				System.out.println(strs.take());
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}).start();
	}
}