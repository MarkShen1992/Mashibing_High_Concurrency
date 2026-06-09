package com.java23;

/**
 * Java 23 新特性：模式中的原始类型（预览）+ Markdown 文档注释
 * 需要 JDK 23+ 运行。
 */
public class Demo01_PrimitivePatterns {

    // Java 23: switch 中匹配原始类型
    // static String classify(int value) {
    //     return switch (value) {
    //         case 0 -> "零";
    //         case int i when i > 0 && i <= 100 -> "正数: " + i;
    //         case int i when i < 0 -> "负数: " + i;
    //         case int i -> "大数: " + i;
    //     };
    // }

    // Java 17 兼容写法
    static String classify(int value) {
        if (value == 0) return "零";
        if (value > 0 && value <= 100) return "正数: " + value;
        if (value < 0) return "负数: " + value;
        return "大数: " + value;
    }

    /// ## Markdown 文档注释 (JEP 467)
    ///
    /// Java 23 支持 `///` 前缀的 Markdown 格式 Javadoc。
    ///
    /// ### 使用示例
    /// ```java
    /// /// 这是 **Markdown** 格式的文档注释
    /// /// - 支持列表
    /// /// - 支持 `代码`
    /// /// - 支持 [链接](url)
    /// public int add(int a, int b) { return a + b; }
    /// ```
    public static void main(String[] args) {
        System.out.println("=== 模式中的原始类型 (Java 23) ===\n");
        for (int v : new int[]{-5, 0, 42, 200}) {
            System.out.println("  classify(" + v + ") = " + classify(v));
        }

        System.out.println("\nJava 23 语法:");
        System.out.println("  return switch (value) {");
        System.out.println("      case 0 -> \"零\";");
        System.out.println("      case int i when i > 0 && i <= 100 -> \"正数: \" + i;");
        System.out.println("      case int i when i < 0 -> \"负数: \" + i;");
        System.out.println("      case int i -> \"大数: \" + i;");
        System.out.println("  };");

        System.out.println("\n其他 Java 23 特性:");
        System.out.println("  - Markdown 文档注释 /// (JEP 467)");
        System.out.println("  - 灵活的构造函数体（第二预览, JEP 482）");
        System.out.println("  - 结构化并发（第三预览, JEP 480）");
        System.out.println("  - 作用域值（第三预览, JEP 487）");
    }
}
