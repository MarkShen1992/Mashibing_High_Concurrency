package com.basic.chapter0100;

/**
 * 变量分类
 * @author MarkShen1992
 * @since 20191101
 */
public class Chapter0104VariableType {

    // 成员变量
    static int a; // 成员变量如何初始化的？在什么时候初始化的？

    public static void main(String[] args) {
        /**
         * 按被声明的位置划分：
         * 成员变量：方法外部，类内部定义的变量
         * 局部变量：方法或语句块内部定义的变量
         * 注意：类外不能声明变量， 方法的参数叫做局部变量
         *
         * 按所属数据类型划分：
         * 基本数据类型
         * 引用类型
         */
        // 局部变量
        int b = 10;
        System.out.println(a);
        System.out.println(b);
        /**
         * 变量作用域：在大括号里面声明的变量出了大括号之后就没有人认识它了
         */
    }
}
