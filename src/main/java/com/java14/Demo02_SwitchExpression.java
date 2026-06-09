package com.java14;

/**
 * Java 14 新特性：Switch 表达式（正式化）
 * 箭头语法 ->，可作为表达式返回值，支持 yield。
 */
public class Demo02_SwitchExpression {

    enum Day { MON, TUE, WED, THU, FRI, SAT, SUN }

    static String dayType(Day day) {
        return switch (day) {
            case MON, TUE, WED, THU, FRI -> "工作日";
            case SAT, SUN -> "周末";
        };
    }

    static int daysInMonth(int month, boolean leap) {
        return switch (month) {
            case 2 -> leap ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }

    static String describe(int n) {
        return switch (n) {
            case 0 -> "零";
            case 1, 2, 3 -> "小数字";
            case 4, 5, 6, 7, 8, 9 -> {
                yield "中等数字: " + n;  // yield 在代码块中返回值
            }
            default -> {
                yield "大数字: " + n;
            }
        };
    }

    public static void main(String[] args) {
        for (Day d : Day.values()) System.out.println(d + " -> " + dayType(d));

        System.out.println();
        for (int m = 1; m <= 12; m++) System.out.printf("%2d月: %d天%n", m, daysInMonth(m, false));

        System.out.println();
        for (int i = 0; i <= 12; i += 3) System.out.println(i + " -> " + describe(i));

        // 对比
        String fruit = "苹果";
        String color = switch (fruit) {
            case "苹果" -> "红色";
            case "香蕉" -> "黄色";
            default -> "未知";
        };
        System.out.println("\n" + fruit + " -> " + color);
    }
}
