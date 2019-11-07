package com.basic.chapter0200;

/**
 * 方法重载:指一个类中可以定义有相同的名字，单参数不同的多个方法，调用时会根据参数的不同
 * 调用不同的方法。
 * 重载方法参数特性：
 *  个数不同
 *  类型不同
 *  顺序不同
 *
 * 构造方法，普通方法皆可重载
 *
 * @author MarkShen1992
 * @since 20191105
 */
public class Chapter0204MethodOverload {

    public static int add(int a, int b) {
        return a + b;
    }

    // 不与第一个方法产生冲突
//    public static void add(int a, int b) {
//        System.out.println(a + b);
//    }

    public static int add(short a, short b) {
        return a + b;
    }

    public static double add(double a, int b) {
        return a + b;
    }

    public static double add(int a, double b) {
        return a + b;
    }

    public static double add(double... args) {
        double tmpVal = 0;
        for (int i=0; i<args.length; i++) {
            tmpVal += args[i];
        }
        return tmpVal;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(1, 2.0));
        System.out.println(add(1.0, 2));
        System.out.println(add(1.0, 1.0));
        System.out.println(add(1.0, 1.0, 1.0));
        short a=1;
        short b=2;
        System.out.println(add(a, b));
    }
}
