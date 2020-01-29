package com.art.concurency.ch08;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    // 10 个线程
    static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int threadNo = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread: " + threadNo);
                    // 执行完打印语句之后，count 数减一
                    countDownLatch.countDown();
                }
            }).start();
        }

        // 当 count 为0时，就可以执行以后的打印语句
        countDownLatch.await();

        System.out.println("all threads finished.");
    }
}
