package com.basic.chapter0600;

import java.util.HashSet;
import java.util.Set;

/**
 * Set：无序，不可重复
 *
 * @author MarkShen
 * @since 20191210
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("a");
        set.add("b");

        for (String str : set) {
            System.out.println(str);
        }
    }
}
