package com.java5;

import static java.lang.Math.*;
import static java.lang.System.out;

/**
 * Java 5 新特性：静态导入 (Static Import)
 */
public class Demo04_StaticImport {

    public static void main(String[] args) {
        // 直接使用 Math 常量和方法，无需 Math. 前缀
        out.println("PI = " + PI);
        out.println("sqrt(144) = " + sqrt(144));
        out.println("max(10, 20) = " + max(10, 20));
        out.println("min(3.14, 2.71) = " + min(3.14, 2.71));
        out.println("abs(-42) = " + abs(-42));
        out.println("pow(2, 10) = " + pow(2, 10));

        // 实际场景：几何计算
        double radius = 5;
        double area = PI * pow(radius, 2);
        double circumference = 2 * PI * radius;
        out.printf("半径 %.0f 的圆: 面积=%.2f, 周长=%.2f%n", radius, area, circumference);
    }
}
