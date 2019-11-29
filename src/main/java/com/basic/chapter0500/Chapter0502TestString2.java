package com.basic.chapter0500;

/**
 * String
 *
 * @author MarkShen
 * @since 20191127
 */
public class Chapter0502TestString2 {
    public static void main(String[] args) {
        String s1 = "Sun java", s2 = "sun Java";
        System.out.println(s1.charAt(1));
        System.out.println(s2.length());
        System.out.println(s1.indexOf("java"));
        System.out.println(s1.indexOf("Java"));
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "我是程序员，我在学Java!";
        System.out.println(s3.replace("我", "你"));
    }
}
