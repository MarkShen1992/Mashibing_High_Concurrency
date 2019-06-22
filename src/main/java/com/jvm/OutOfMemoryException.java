package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MarkShen
 * @since 20190622
 * Exception: OutOfMemoryError 抛出，可以改造成多线程往List里面加
 */
public class OutOfMemoryException {
    static List<Object> os = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            os.add(new Object());
        }
    }
}
