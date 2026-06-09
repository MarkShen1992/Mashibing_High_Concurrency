package com.java12;

/**
 * Java 12 新特性：String.indent() / String.transform()
 */
public class Demo01_StringIndent {

    public static void main(String[] args) {
        // indent(n) - 给每行添加缩进
        String text = "第一行\n第二行\n第三行";
        System.out.println("indent(4):");
        System.out.print(text.indent(4));

        System.out.println("indent(8):");
        System.out.print(text.indent(8));

        // 负数缩进
        String indented = "    Hello\n    World";
        System.out.println("indent(-4): [" + indented.indent(-4).strip() + "]");

        // transform(Function) - 链式转换
        String hello = "hello java 12";
        System.out.println("\ntransform 链式:");
        String result = hello
                .transform(String::toUpperCase)
                .transform(s -> ">> " + s + " <<");
        System.out.println(result);

        // transform 返回非 String 类型
        int len = hello.transform(String::length);
        boolean isLong = hello.transform(s -> s.length() > 20);
        System.out.println("长度: " + len + ", 超过20字符: " + isLong);
    }
}
