package com.java7;

/**
 * Java 7 新特性：二进制字面量与数字下划线
 */
public class Demo06_BinaryLiteral {

    public static void main(String[] args) {
        // 二进制字面量 0b/0B
        int bin1 = 0b1010;         // 10
        int bin2 = 0B11110000;     // 240
        System.out.println("0b1010 = " + bin1);
        System.out.println("0B11110000 = " + bin2);

        // 各进制表示 42
        System.out.println("\n42 的各进制:");
        System.out.println("  十进制: " + 42);
        System.out.println("  二进制: " + 0b101010);
        System.out.println("  八进制: " + 052);
        System.out.println("  十六进制: " + 0x2a);

        // 数字下划线提高可读性
        long card = 1234_5678_9012_3456L;
        double pi = 3.141_592_653_589_793;
        int hexBytes = 0xFF_EC_DE_5E;
        int binary = 0b0001_0010_0011_0100;
        System.out.println("\n数字下划线:");
        System.out.println("  卡号: " + card);
        System.out.println("  PI: " + pi);
        System.out.println("  Hex: 0x" + Integer.toHexString(hexBytes));
        System.out.println("  Binary: " + binary);

        // 位操作
        int flags = 0b0000_0000;
        flags |= 0b0000_0001;
        flags |= 0b0000_1000;
        System.out.println("\nflags = 0b" + Integer.toBinaryString(flags));
        System.out.println("bit 0: " + ((flags & 1) != 0));
        System.out.println("bit 3: " + ((flags & 8) != 0));
    }
}
