package com.art.concurency.ch04;

/**
 * https://docs.oracle.com/javase/8/docs/api/index.html
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread.State[] values = Thread.State.values();
        System.out.println(values);
    }
}
