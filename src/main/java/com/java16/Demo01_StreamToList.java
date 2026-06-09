package com.java16;

import java.util.stream.*;
import java.util.List;

/**
 * Java 16 新特性：Stream.toList()
 * 直接将流收集为不可变 List，替代 .collect(Collectors.toList())。
 */
public class Demo01_StreamToList {

    record Student(String name, List<Integer> scores) {}

    public static void main(String[] args) {
        // Stream.toList() - 返回不可变 List
        List<String> names = Stream.of("张三", "李四", "王五", "赵六")
                .filter(n -> n.length() >= 2)
                .toList();
        System.out.println("toList(): " + names);

        // 不可变
        try { names.add("新人"); } catch (UnsupportedOperationException e) {
            System.out.println("不可变: UnsupportedOperationException");
        }

        // 对比
        System.out.println("\nJava 16前: .collect(Collectors.toList())  // 可变");
        System.out.println("Java 16后: .toList()                      // 不可变");

        // Stream.mapMulti() - Java 16 新增
        List<Character> chars = Stream.of("Hello", "World")
                .<Character>mapMulti((str, consumer) -> {
                    for (char c : str.toCharArray()) consumer.accept(c);
                })
                .toList();
        System.out.println("\nmapMulti 拆字符: " + chars);

        // mapMulti 过滤 + 转换
        List<Student> students = List.of(
                new Student("张三", List.of(85, 90, 78)),
                new Student("李四", List.of(92, 88)),
                new Student("王五", List.of(60, 75, 95))
        );
        List<String> high = students
                .<String>mapMulti((s, consumer) -> {
                    for (int score : s.scores()) {
                        if (score >= 85) consumer.accept(s.name() + ":" + score);
                    }
                })
                .toList();
        System.out.println("85分以上: " + high);
    }
}
