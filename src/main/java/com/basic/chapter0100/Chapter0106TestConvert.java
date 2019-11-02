package com.basic.chapter0100;

/**
 * 练习程序
 * @author MarkShen1992
 * @since 20191102
 */
public class Chapter0106TestConvert {
    public static void main(String arg[]) {
        int i1 = 123;
        int i2 = 456;
        double d1 = (i1 + i2) * 1.2;// 系统将转换double型进行运算
        float f1 = (float) ((i1 + i2) * 1.2);// 需要加强制转换符号
        byte b1 = 67;
        byte b2 = 89;
        byte b3 = (byte) (b1 + b2);// 系统将转换为 int 进行运算，然后再转换回来
        System.out.println(b3);
        double d2 = 1e200;
        float f2 = (float) d2;// 产生溢出
        System.out.println(f2);

        float f3 = 1.23f;// 必须加f, 浮点数直接砍掉是不可以的
        long l1 = 123;
        long l2 = 30000000000L;// 必须加L
        float f = l1 + l2 + f3;// 系统将转换float型计算
        long l = (long) f;// 强制转换会舍去小数部分（非四舍五入）
    }
}