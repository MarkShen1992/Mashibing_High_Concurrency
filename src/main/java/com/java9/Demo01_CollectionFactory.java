package com.java9;

import java.util.*;

/**
 * Java 9 新特性：集合工厂方法 List.of() / Set.of() / Map.of()
 */
public class Demo01_CollectionFactory {

    public static void main(String[] args) {
        // List.of() - 不可变列表
        List<String> fruits = List.of("苹果", "香蕉", "橙子");
        System.out.println("List: " + fruits);

        // Set.of() - 不可变集合
        Set<Integer> primes = Set.of(2, 3, 5, 7, 11);
        System.out.println("Set: " + primes);

        // Map.of() - 不可变映射（最多10对）
        Map<String, Integer> scores = Map.of("张三", 90, "李四", 85, "王五", 92);
        scores.forEach((k, v) -> System.out.println("  " + k + ": " + v));

        // Map.ofEntries() - 超过10对
        Map<String, String> capitals = Map.ofEntries(
                Map.entry("中国", "北京"), Map.entry("日本", "东京"),
                Map.entry("美国", "华盛顿"), Map.entry("英国", "伦敦"),
                Map.entry("法国", "巴黎"), Map.entry("德国", "柏林"),
                Map.entry("俄罗斯", "莫斯科"), Map.entry("巴西", "巴西利亚"),
                Map.entry("澳大利亚", "堪培拉"), Map.entry("加拿大", "渥太华"),
                Map.entry("印度", "新德里")
        );
        System.out.println("\n首都:");
        capitals.forEach((k, v) -> System.out.println("  " + k + " -> " + v));

        // 不可变集合不能修改
        try { fruits.add("葡萄"); } catch (UnsupportedOperationException e) {
            System.out.println("\n不可变列表不能添加: UnsupportedOperationException");
        }

        // 不允许 null
        try { List.of("a", null); } catch (NullPointerException e) {
            System.out.println("不可变集合不允许 null: NullPointerException");
        }

        // copyOf() - 创建不可变副本
        List<String> mutable = new ArrayList<>(Arrays.asList("x", "y", "z"));
        List<String> copy = List.copyOf(mutable);
        mutable.add("w");
        System.out.println("\n原列表: " + mutable);
        System.out.println("副本: " + copy);
    }
}
