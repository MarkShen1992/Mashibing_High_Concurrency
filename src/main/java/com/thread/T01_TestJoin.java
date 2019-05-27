package com.thread;

import java.util.concurrent.TimeUnit;

public class T01_TestJoin {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread(), "t1");
        Thread t2 = new Thread(new MyThread(), "t2");

        try {
            // Waits for this thread to die.
            t2.join(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        // 线程通信
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}