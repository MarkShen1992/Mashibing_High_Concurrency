package com.thread;

public interface AnimalBehavior {
    default void eat() {
        System.out.println("hello world");
    }
}
