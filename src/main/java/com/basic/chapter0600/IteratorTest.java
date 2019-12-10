package com.basic.chapter0600;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Iterator 测试
 *
 * @author MarkShen
 * @since 20191210
 */
public class IteratorTest {
    public static void main(String[] args) {
        // List 有序，可以重复
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        for (Iterator it = list.iterator(); it.hasNext(); ) {
            if ("d".equals(it.next())) {
                it.remove();
                // list.remove("d");  // 会抛出 java.util.ConcurrentModificationException 异常
            }
        }

        for (String str : list) {
            System.out.println(str);
        }
    }
}
