package com.art.concurrency.ch08;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用户遗传算法
 * 用于校对工作
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String a = "银行流水A";
                    // 同步点，第一个线程执行exchange函数的时候，线程1会等待第二线程也执行 exchange 函数
                    String msg = exgr.exchange(a);
                    System.out.println("msg=" + msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String b = "银行流水B";
                    String a = exgr.exchange(b);
                    System.out.println("a与b数据是否一致：" + a.equals(b));
                    System.out.println("A=" + a);
                    System.out.println("B=" + b);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }
}
