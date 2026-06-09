package com.java10;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java 10 新特性：局部变量类型推断 var
 */
public class Demo01_VarKeyword {

    public static void main(String[] args) {
        // 基本类型推断
        var message = "Hello Java 10";   // String
        var number = 42;                  // int
        var pi = 3.14;                    // double
        System.out.println(message + ", " + number + ", " + pi);

        // 集合类型推断
        var list = new ArrayList<String>();
        list.add("Java"); list.add("10");
        var map = new HashMap<String, Integer>();
        map.put("版本", 10);
        System.out.println("list: " + list + ", map: " + map);

        // for 循环
        var names = List.of("张三", "李四", "王五");
        for (var name : names) System.out.println("  " + name);
        for (var i = 0; i < names.size(); i++) System.out.println("  [" + i + "] " + names.get(i));

        // try-with-resources
        try (var input = new java.io.FileInputStream("pom.xml")) {
            System.out.println("pom.xml 第一字节: " + input.read());
        } catch (Exception e) {
            System.out.println("读取失败: " + e.getMessage());
        }

        // Stream
        var result = list.stream().filter(s -> s.length() > 2).collect(Collectors.joining(", "));
        System.out.println("过滤: " + result);

        // 限制
        System.out.println("\nvar 限制:");
        System.out.println("  1. 只能用于局部变量");
        System.out.println("  2. 不能用于成员变量、方法参数、返回值");
        System.out.println("  3. 必须初始化且不能为 null");
    }
}
