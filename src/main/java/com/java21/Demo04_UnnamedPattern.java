package com.java21;

import java.util.List;

/**
 * Java 21 新特性（LTS）：未命名模式与变量 _（预览）
 * 用 _ 表示不使用的变量。需要 JDK 21+ 运行。
 */
public class Demo04_UnnamedPattern {

    record Point(int x, int y) {}

    public static void main(String[] args) {
        // Java 21 之前：必须起名
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {  // e 不用但必须声明
            System.out.println("除以零错误");
        }

        String[] items = {"a", "b", "c"};
        int count = 0;
        for (String item : items) count++;  // item 不用但必须声明
        System.out.println("计数: " + count);

        // Java 21+ 语法
        System.out.println("\nJava 21+ 语法:");
        System.out.println("  catch (ArithmeticException _) { ... }");
        System.out.println("  for (var _ : items) count++;");
        System.out.println("  if (obj instanceof Point(var x, var _)) { ... }");
        System.out.println("  case Point(var x, var _) -> \"x=\" + x;");
        System.out.println("  case _ -> \"其他\";");
        System.out.println("  try (var _ = new FileInputStream(\"f\")) { ... }");
        System.out.println("  (_, v) -> process(v)");

        System.out.println("\n好处: 明确表达「故意不使用」，消除 IDE 警告");
    }
}
