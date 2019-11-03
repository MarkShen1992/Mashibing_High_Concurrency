package com.basic.chapter0100;

/**
 * method
 * @author MarkShen1992
 * @since 20191103
 */
public class Chapter0113TestMethod2 {

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }

    public static void main(String[] args) {
        Chapter0113TestMethod2 t = new Chapter0113TestMethod2();
        System.out.println("Max = " + t.max(3, 4));
        System.out.println("Min = " + t.min(3, 4));
        // System.out.println(Max(3, 4));
    }
}