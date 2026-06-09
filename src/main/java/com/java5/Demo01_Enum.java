package com.java5;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * Java 5 新特性：枚举类型 (Enum)
 */
public class Demo01_Enum {

    enum Season { SPRING, SUMMER, AUTUMN, WINTER }

    enum Color {
        RED("红色", 1), GREEN("绿色", 2), BLUE("蓝色", 3);
        private final String name;
        private final int code;
        Color(String name, int code) { this.name = name; this.code = code; }
        public String getName() { return name; }
        public int getCode() { return code; }
    }

    enum Operation {
        ADD { public double apply(double x, double y) { return x + y; } },
        SUB { public double apply(double x, double y) { return x - y; } },
        MUL { public double apply(double x, double y) { return x * y; } };
        public abstract double apply(double x, double y);
    }

    public static void main(String[] args) {
        // 遍历枚举
        for (Season s : Season.values()) {
            System.out.println(s + " ordinal=" + s.ordinal());
        }

        // switch 中使用枚举
        Season season = Season.SUMMER;
        switch (season) {
            case SPRING: System.out.println("春天"); break;
            case SUMMER: System.out.println("夏天"); break;
            case AUTUMN: System.out.println("秋天"); break;
            case WINTER: System.out.println("冬天"); break;
        }

        // 带属性的枚举
        for (Color c : Color.values()) {
            System.out.println(c + " -> " + c.getName() + "(" + c.getCode() + ")");
        }

        // EnumSet
        EnumSet<Season> warm = EnumSet.of(Season.SPRING, Season.SUMMER);
        System.out.println("温暖季节: " + warm);

        // EnumMap
        EnumMap<Season, String> map = new EnumMap<>(Season.class);
        map.put(Season.SPRING, "3-5月");
        map.put(Season.SUMMER, "6-8月");
        map.forEach((k, v) -> System.out.println(k + ": " + v));

        // 抽象方法枚举
        double a = 10, b = 3;
        for (Operation op : Operation.values()) {
            System.out.printf("%.0f %s %.0f = %.2f%n", a, op, b, op.apply(a, b));
        }
    }
}
