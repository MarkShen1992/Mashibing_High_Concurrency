package com.basic.chapter0100;

/**
 * 数据类型
 * @author MarkShen1992
 * @since 20191102
 */
public class Chapter0105DataType {
    public static void main(String[] args) {
        /**
         * 基本数据类型：
         * 数值型：
         *      整数类型：byte, short, int, long
         *      浮点类型：float, double
         * 字符型(文本)：char
         *      Java里面采用Unicode编码，每个字符占两个字节，因而可使用十六进制编码形式表示。
         *      XML中编码问题
         *      每种不同的文字，在计算机中表示为010101...
         *      每个字节8位
         *      中文编码问题
         *      Unicode一统江湖，统一了全世界所有编码
         *      https://en.wikipedia.org/wiki/Unicode 需要科学上网
         * 布尔型(逻辑)：boolean
         *
         * 内存大小，小格的布局
         * Java各个整数类型有固定的表数范围和字段长度，其不受具体操作系统影响，可以在各个平台移植。
         */

        /**
         * In Oracle’s Java Virtual Machine implementation, boolean arrays in the Java
         * programming language are encoded as Java Virtual Machine byte arrays, using 8 bits per
         * boolean element.
         *                                                -- 《JVM官方文档》
         */
        boolean flag = true;
        if (flag) {
            System.out.println("flag is valid.");
        }

        // 字符型, 占两个字节
        char c = 'a';
        System.out.println(c);

        /**
         * 数类型, 占用内存1个字节, 1byte
         * Java语言整型常量的三种表示
         * 十进制
         * 八进制：编码算法中使用，012
         * 十六进制
         *
         * Java语言整形常量默认为int类型
         */
        byte by = 123;
        System.out.println(by);

        // 2 bytes
        short sh = 123;
        System.out.println(sh);

        // 4 bytes
        int num = 123;
        System.out.println(num);

        // 8 bytes
        long lon = 1234L;
        System.out.println(lon);

        /**
         * 浮点类型：浮点数在计算机中的表示，浮点数是有一定的误差的
         * float, double
         * 浮点数默认为 double类型
         */

        // 8 bytes
        double PI = 3.14;
        System.out.println(PI);

        // 4 bytes, 精度
        float PI2 = 3.14f;
        // float PI2 = 3.14F;
        System.out.println(PI2);

        /**
         * 引用数据类型:
         * 类(class)
         * 接口(interface)
         * 数组(array)
         */

    }
}
