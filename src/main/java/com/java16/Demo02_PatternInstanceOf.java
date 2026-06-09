package com.java16;

import java.util.List;

/**
 * Java 16 新特性：instanceof 模式匹配（正式化）
 * 类型检查的同时自动类型转换，消除显式强转。
 */
public class Demo02_PatternInstanceOf {

    static String describe(Object obj) {
        if (obj instanceof String s) {
            return "字符串: \"" + s + "\", 长度=" + s.length();
        } else if (obj instanceof Integer i) {
            return "整数: " + i + (i > 0 ? "(正)" : "(非正)");
        } else if (obj instanceof List<?> list) {
            return "列表: 大小=" + list.size();
        }
        return "其他: " + obj;
    }

    public static void main(String[] args) {
        Object[] tests = {"Hello Java 16", 42, -5, List.of(1, 2, 3), 3.14, null};
        for (Object o : tests) System.out.println(describe(o));

        // 短路逻辑
        String input = "Hello";
        if (input instanceof String s && s.length() > 3) {
            System.out.println("\n字符串长度>3: " + s);
        }

        // 简化 equals
        System.out.println("\n传统 equals:");
        System.out.println("  if (!(obj instanceof MyClass)) return false;");
        System.out.println("  MyClass other = (MyClass) obj;");
        System.out.println("  return this.name.equals(other.name);");
        System.out.println("\nJava 16:");
        System.out.println("  return obj instanceof MyClass other && this.name.equals(other.name);");

        // null 安全
        System.out.println("\nnull instanceof String s -> " + (null instanceof String s));
    }
}
