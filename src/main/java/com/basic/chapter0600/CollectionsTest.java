package com.basic.chapter0600;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 工具类测试 Collections
 *
 * @author MarkShen
 * @since 20191217
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<String> strs = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            strs.add("a" + i);
        }
        System.out.println(strs);

        Collections.shuffle(strs);
        System.out.println(strs);

        Collections.reverse(strs);
        System.out.println(strs);

        Collections.sort(strs);
        System.out.println(strs);
        System.out.println(Collections.binarySearch(strs, "a5"));
    }
}
