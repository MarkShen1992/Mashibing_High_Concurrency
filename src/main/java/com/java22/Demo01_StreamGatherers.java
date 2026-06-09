package com.java22;

import java.util.*;
import java.util.stream.*;

/**
 * Java 22 新特性：Stream Gatherers（预览）+ 未命名变量正式化 + FFM API 正式化
 * 需要 JDK 22+ 运行。
 */
public class Demo01_StreamGatherers {

    public static void main(String[] args) {
        // Stream Gatherers 概念演示（用 Java 17 模拟）
        var numbers = IntStream.rangeClosed(1, 10).boxed().toList();

        // 模拟 windowFixed(3)
        System.out.println("windowFixed(3):");
        for (int i = 0; i < numbers.size(); i += 3) {
            System.out.println("  " + numbers.subList(i, Math.min(i + 3, numbers.size())));
        }

        // 模拟 windowSliding(3)
        System.out.println("\nwindowSliding(3):");
        for (int i = 0; i <= numbers.size() - 3; i++) {
            System.out.println("  " + numbers.subList(i, i + 3));
        }

        // 模拟 scan（前缀和）
        System.out.println("\nscan(0, sum):");
        int sum = 0;
        for (int n : List.of(1, 2, 3, 4, 5)) {
            sum += n;
            System.out.print(sum + " ");
        }
        System.out.println();

        // Java 22 Gatherers API
        System.out.println("\nJava 22 API:");
        System.out.println("  stream.gather(Gatherers.windowFixed(3))");
        System.out.println("  stream.gather(Gatherers.windowSliding(3))");
        System.out.println("  stream.gather(Gatherers.scan(0, Integer::sum))");
        System.out.println("  stream.gather(Gatherers.fold(seed, fn))");
        System.out.println("  stream.gather(Gatherers.mapConcurrent(10, url -> fetch(url)))");

        System.out.println("\n其他 Java 22 特性:");
        System.out.println("  - 未命名变量 _ 正式化 (JEP 456)");
        System.out.println("  - Foreign Function & Memory API 正式化 (JEP 454)");
        System.out.println("  - 隐式声明类/实例 main (预览, JEP 458)");
    }
}
