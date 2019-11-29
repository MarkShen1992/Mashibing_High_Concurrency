package com.basic.chapter0500;

/**
 * 常用类介绍
 * 字符串
 * 基本类型包装类
 * Math类
 * File类
 * 枚举类
 */
public class Chapter0501CommonUseClass {
    public static void main(String[] args) {
        /**
         *
         */
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello";
        System.out.println(s1 == s3);

        String s4 = "he" + "llo";
        System.out.println(s3 == s4);

        String s5 = new String("hello");
        System.out.println(s3 == s5);
        System.out.println(s3.equals(s5));

        String s6 = new String("he");
        String s7 = s6 + "llo";
        System.out.println(s3 == s7);
    }
}
