package com.thread;

/**
 * @author MarkShen
 */
public interface AnimalBehavior {
    default void eat() {
        System.out.println("hello world");
    }
}
