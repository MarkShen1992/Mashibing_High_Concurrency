package com.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * 唤醒“指定”的某个线程
 *
 * 使用Java6引入了LockSupport这个类
 * @author MarkShen
 */
public class NotifySpecifiedThread {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(()->{
            System.out.println("start");
            LockSupport.park(); // park可以让当前线程进入wait状态
            System.out.println("continue");
        });
        t.start();

        Thread.sleep(1000);
        LockSupport.unpark(t); // unpark可以解除指定线程的wait态，不需要拥有某个对象的特定锁
    }
}
