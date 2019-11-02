package com.basic.chapter0100;

/**
 * 基本数据类型转换
 * @author MarkShen1992
 * @since 20191102
 */
public class Chapter0106BasicDataTypeConvertPrinciple {
    public static void main(String[] args) {
        /**
         * 整形，浮点型，字符型的数据在混合运算中相互转换，原则如下：
         * 1）容量小的数据类型自动转换为容量大的数据类型，数据类型按容量大小(表示的数的大小)排序:
         *      byte, short, char -> int -> long -> float -> double
         *      byte, short, char之间不会相互转换，他们三者在计算前要先转换为 int.
         * 2）容量大的数据类型转换为容量小的数据类型时，要加上强制转换符，但可能造成
         *    精度降低或溢出
         * 3）有多种数据类型的数据进行混合运算时，系统首先自动将所有数据转换成容量最大
         *    的那一种数据类型，然后再进行计算
         * 4）实数类型默认为 double
         * 5）证书类型默认为 int
         */
    }
}