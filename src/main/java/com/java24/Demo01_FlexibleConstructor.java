package com.java24;

/**
 * Java 24 新特性：灵活的构造函数体（预览/正式化）
 * 允许在 super() 之前执行语句。需要 JDK 24+ 运行。
 */
public class Demo01_FlexibleConstructor {

    // Java 24: super() 之前可以执行语句
    // class ValidatedRange extends Number {
    //     private final int min, max, span;
    //     ValidatedRange(int a, int b) {
    //         if (a == b) throw new IllegalArgumentException("不能相等");
    //         this.min = Math.min(a, b);  // super() 之前赋值!
    //         this.max = Math.max(a, b);
    //         this.span = this.max - this.min;
    //         super();
    //     }
    // }

    // Java 17 兼容写法
    static class Range {
        final int min, max, span;
        Range(int a, int b) {
            if (a == b) throw new IllegalArgumentException("不能相等");
            this.min = Math.min(a, b);
            this.max = Math.max(a, b);
            this.span = this.max - this.min;
        }
        public String toString() { return "[" + min + ", " + max + "] span=" + span; }
    }

    public static void main(String[] args) {
        System.out.println("=== 灵活的构造函数体 (Java 24) ===\n");

        Range r1 = new Range(3, 10);
        Range r2 = new Range(20, 5);
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);

        try { new Range(5, 5); } catch (IllegalArgumentException e) {
            System.out.println("Range(5,5): " + e.getMessage());
        }

        System.out.println("\nJava 24 语法（super() 之前执行语句）:");
        System.out.println("  class Child extends Parent {");
        System.out.println("      Child(int input) {");
        System.out.println("          if (input < 0) throw new IllegalArgumentException();");
        System.out.println("          this.value = input;  // super() 之前初始化!");
        System.out.println("          super();");
        System.out.println("      }");
        System.out.println("  }");

        System.out.println("\n其他 Java 24 特性:");
        System.out.println("  - Stream Gatherers 正式化 (JEP 485)");
        System.out.println("  - 模块导入声明（预览, JEP 476）");
        System.out.println("  - 紧凑对象头 (JEP 450)");
    }
}
