package com.art.concurrency.ch01;

/**
 * 1. 循环次数
 * 2. 串并行程序实行时间
 * 3. Lmbench3 http://www.bitmover.com/lmbench/ 上下文切换的时长
 * 4. vmstat 上下文切换的次数
 * 5. 如何减少上下文切换
 *  无锁并发编程， CAS算法， 使用最少线程， 使用协程
 *  无锁并发编程：不同线程处理不同段的数据
 */
public class ConcurrencyTest {
    private static final long count = 100001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial: " + time);
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();

        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency: " + time);
    }

}