package com.program;

/**
 * 编写一个程序：把1-100的数字打印出来。不过，要把3的倍数打印成Bizz，把5的倍数打印成Buzz, 而这个数字 既是3的倍数又是5的倍数，就打成Bizz-Buzz。
 */
public class FizzBuzzDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                System.out.print(" Bizz ");
            } else if (i % 3 != 0 && i % 5 == 0) {
                System.out.print(" Buzz ");
            } else if (i % 3 == 0 && i % 5 == 0) {
                System.out.print(" Bizz-Buzz ");
            } else {
                System.out.print(" " + i + " ");
            }
        }
    }
}
