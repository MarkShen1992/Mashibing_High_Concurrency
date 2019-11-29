package com.basic.chapter0500;

import java.util.Date;

/**
 * String
 *
 * @author MarkShen
 * @since 20191127
 */
public class Chapter0503TestString3 {
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

        Date d = new Date();
        System.out.println(d);

        // 计算j是几位数
        int j = 1234657;
        String num = String.valueOf(j);
        System.out.println("j是" + num.length() + "位数.");

        String s2 = "shen,jun,yu";
        System.out.println(s2.split(",").length);

        String s3 = "asjljladjflAJSDLAJDSAJS,,,...,ASJDS";
        System.out.println("大写字符数: " + countA2Z(s3));
        System.out.println("小写字符数：" + counta2z(s3));
        System.out.println("其它字符数：" + countOtherCharacter(s3));
        System.out.println(s3.length());
    }

    /**
     * 计算大写字符数量
     *
     * @param string
     * @return
     */
    private static int countA2Z(String string) {
        char[] chars = string.toCharArray();
        int count = 0;
        for (char c : chars) {
            if ('A' <= c && c <= 'Z') {
                count ++;
            }
        }
        return count;
    }

    private static int countLowerCase(String string) {
        int count = 0;
        for (int i=0; i<string.length(); i++) {
            char tmp = string.charAt(i); // 注意 charAt 方法的使用
            if ('A' <= tmp && tmp <= 'Z') {
                count ++;
            }
        }
        return count;
    }

    private static int countLowerCase2(String string) {
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        int count = 0;
        for (int i=0; i<string.length(); i++) {
            char tmp = string.charAt(i); // 注意 charAt 方法的使用
            if (s1.indexOf(tmp) != -1) {
                count ++;
            }
        }
        return count;
    }

    /**
     * 计算小写字符数量
     *
     * @param string
     * @return
     */
    private static int counta2z(String string) {
        char[] chars = string.toCharArray();
        int count = 0;
        for (char c : chars) {
            if ('a' <= c && c <= 'z') {
                count ++;
            }
        }
        return count;
    }

    /**
     * 计算其他字符数个数
     *
     * @param string
     * @return
     */
    private static int countOtherCharacter(String string) {
        return string.length() - countA2Z(string) - counta2z(string);
    }

}
