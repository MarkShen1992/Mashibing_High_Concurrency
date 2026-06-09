package com.java7;

import java.util.*;

/**
 * Java 7 新特性：钻石操作符 <>
 * 省略泛型的重复类型声明。
 */
public class Demo02_DiamondOperator {

    public static void main(String[] args) {
        // Java 7 之前
        List<String> old1 = new ArrayList<String>();
        Map<String, List<Integer>> old2 = new HashMap<String, List<Integer>>();

        // Java 7: 使用 <>
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Diamond");
        System.out.println("List: " + list);

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> nums = new ArrayList<>();
        nums.add(1); nums.add(2); nums.add(3);
        map.put("nums", nums);
        System.out.println("Map: " + map);

        // 嵌套泛型简化
        Map<String, Map<String, Integer>> nested = new HashMap<>();
        Map<String, Integer> inner = new HashMap<>();
        inner.put("语文", 90);
        inner.put("数学", 95);
        nested.put("张三", inner);
        System.out.println("嵌套: " + nested);
    }
}
