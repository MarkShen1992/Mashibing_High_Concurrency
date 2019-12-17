package com.basic.chapter0100;

/**
 * 常量与变量
 * @author MarkShen1992
 * @since 20191101
 */
public class Chapter0103ConstantAndVariable {
    public static void main(String[] args) {
        /**
         * 从本质上讲，变量其实就是内存中的一小块区域，使用变量名来访问这块区域，
         * 因此，每一个变量使用前必须要先声明（申请内存），然后进行赋值（填充内容），才可以使用。
         * 不同数据类型所占内存空间不同。
         */
        int num = 123; // 所在位置，栈内存
        double d = 3.14;
        char ch = 'a';
        boolean flag = true;
        String str = "Hello world!";
        // 不可变的变量，类似于C语言中的 const 修饰的量，与Java中的 final 对应
        final int var = 10;
        float PI = 3.14f;
        

        // 下面注释掉的这句话会有编译错误
        // var = 12;

        /**
         * 重点内容：******
         * 程序的执行过程：《深入Java虚拟机》，可以找官方英文版
         * .exe文件放到操作系统直接执行；.class放到JVM中执行
         * 程序首先从硬盘加载（load）到内存区域中
         * 然后，操作系统会找到加载到内存中程序的main方法
         * 然后，执行过程中的内存管理
         * 内存管理中，在程序运行的时候，内存分为4个部分，不同操作系统不同
         * 分别是：堆，栈，代码区，方法区
         * 堆(Heap)：Java代码new出来的东西
         * 栈(Stack)：局部变量
         * 代码区(Code segment)：存放代码
         * 数据区(Data segment)：静态变量，字符串变量
         */
    }
}
