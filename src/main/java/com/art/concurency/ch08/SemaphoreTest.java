package com.art.concurency.ch08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 可以用作流量控制，特别是公用资源有限的应用场景，如数据库连接。
 * 有一个需求，要读取几万个文件的数据，因为是IO密集型任务，我们可以启动几十个线程并发读取
 * 但是如果读到内存后，还需要存储到数据库中，而且数据库的连接的连接数只有10个，这时我们必
 * 须控制只有10个线程同时获取数据库连接保存数据，否则无法获取数据库连接。
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);

    /**
     * 最大并发数 10
     */
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data.");
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
