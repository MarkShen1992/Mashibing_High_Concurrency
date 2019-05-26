package com.mark.concurrent26;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 注意与Runnable的区别
 * https://blog.csdn.net/qq_27258799/article/details/51451143
 * https://www.cnblogs.com/frinder6/p/5507082.html
 * @author MarkShen
 *
 */
public class T03_Callable implements Callable<String> {

	private String acceptStr;

	public T03_Callable(String acceptStr) {
		this.acceptStr = acceptStr;
	}

	@Override
	public String call() throws Exception {
		// 任务阻塞 1 秒
		Thread.sleep(1000);
		return this.acceptStr + " append some chars and return it!";
		// return null;
	}

	public static void main(String[] args) throws Exception {
		Callable<String> callable = new T03_Callable("my callable test!");
		FutureTask<String> task = new FutureTask<>(callable);
		long beginTime = System.currentTimeMillis();
		// 创建线程
		new Thread(task).start();
		// 调用get()阻塞主线程，反之，线程不会阻塞
		String result = task.get();
		long endTime = System.currentTimeMillis();
		System.out.println("hello : " + result);
		System.out.println("cast : " + (endTime - beginTime) / 1000 + " second!");
	}

}