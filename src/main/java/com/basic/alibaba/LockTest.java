package com.basic.alibaba;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description alibaba
 * @author shenjy
 * @since 2019/08/04
 */
public class LockTest {
    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        try {
            lock.tryLock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
