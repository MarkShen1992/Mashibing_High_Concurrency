package com.basic.chapter0100;

/**
 * PPT中未敲完的程序
 *
 * @author MarkShen
 * @since 20191207
 */
public class Test02 {
    public static void main(String[] args) {
        boolean a, b, c;
        a = true;
        b = false;
        c = a & b;
        System.out.println("c=" + c);
        c = a | b;
        System.out.println("c=" + c);
        c = a ^ b;
        System.out.println("c=" + c);
        c = !a;
        System.out.println("c=" + c);
        c = a && b;
        System.out.println("c=" + c);
        c = a || b;
        System.out.println("c=" + c);

        int i = 1, j = 2;
        boolean flag1 = (i > 3) && ((i + j) > 5);
        boolean flag2 = (i < 2) && ((i + j) < 6);

        // 三目运算符号
        int score = 80;
        String result = score > 60 ? "及格" : "不及格";
        System.out.println(result);

        // fab
        System.out.println(f(3));
    }

    public static int f(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return f(n - 1) + f(n - 2);
        }
    }
}
