package com.basic.chapter0100;

/**
 * if 表达式
 * @author MarkShen1992
 * @since 20191103
 */
public class Chapter0107TestIF {
    public static void main(String[] args) {
        int i = 20;
        if (i < 20) {
            System.out.println("<20");
            System.out.println("<20");
        } else if (i < 40) {
            System.out.println("<40");
        } else if (i < 60) {
            System.out.println("<60");
        } else
            // 当if...else...语句中只有一个语句，可以省略大括号，不推荐使用
            System.out.println(">=60");
        System.out.println(">=60");
    }
}