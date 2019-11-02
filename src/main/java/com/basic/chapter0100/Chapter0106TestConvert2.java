package com.basic.chapter0100;

public class Chapter0106TestConvert2 {
    public static void main(String[] args) {
        int i = 1, j = 12;
        float f1 = (float) 0.1;  //0.1f
        float f2 = 123;
        long l1 = 12345678, l2 = 8888888888L;
        double d1 = 2e20, d2 = 124;
        byte b1 = 1, b2 = 2, b3 = 127;
        j = j + 10;
        i = i / 10;
        // i = i * 0.1;
        i = (int) (i * 0.1);
        char c1 = 'a', c2 = 125;
        byte b = (byte) (b1 - b2);
        char c = (char) (c1 + c2 - 1);
        float f3 = f1 + f2;
        float f4 = (float) (f1 + f2 * 0.1);
        double d = d1 * i + j;
        float f = (float) (d1 * 5 + d2);
    }
}