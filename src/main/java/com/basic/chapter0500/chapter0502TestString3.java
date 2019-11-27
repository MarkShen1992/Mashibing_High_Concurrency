package com.basic.chapter0500;

/**
 * String
 *
 * @author MarkShen
 * @since 20191127
 */
public class chapter0502TestString3 {
    public static void main(String[] args) {
        String s1 = "Welcome to Java world!";
        System.out.println(s1.codePointAt(0));
        System.out.println(s1.codePointBefore(1));
        System.out.println(s1.codePointCount(0, 2));
        System.out.println(s1.compareTo("Java world!"));
        System.out.println(s1.concat("+"));
        System.out.println(s1.contains("Java"));
        System.out.println(s1.contentEquals("Welcome to Java world!"));
        System.out.println(s1.toUpperCase());
        System.out.println(s1.toLowerCase());
        System.out.println(String.valueOf(3.14));
        System.out.println(s1.trim());
        System.out.println(s1.toCharArray().length);
        System.out.println(s1.substring(1));
        System.out.println(s1.substring(0, 1));
        System.out.println(s1.subSequence(0, 1));
        System.out.println(s1.startsWith("Welcome"));
        System.out.println(s1.startsWith("Welcome", 5));
        System.out.println(s1.split(" ").length);
        System.out.println("java.lang".split("\\.").length);
    }
}
