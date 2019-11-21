package com.basic.chapter0300;

/**
 * 方法异常
 *
 * @author MarkShen
 * @since 20191121
 */
public class Chapter0302MethodException {
    public static void main(String[] args) {
        crunch(null);
    }

    static void crunch(int[] a) {
        mash(a);
    }
    static void mash(int[] b) {
        System.out.println(b[0]);
    }
}


