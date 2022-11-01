package com.thread;

public class T {
    public static void main(String[] args) {
        int a = 2;
        switch (a) {
            case 1:
            case 2:
                System.out.println(a);
                break;
            default:
                System.out.println(a + 1);
                break;
        }
    }
}
