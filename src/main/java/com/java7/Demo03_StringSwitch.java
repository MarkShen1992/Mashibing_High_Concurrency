package com.java7;

/**
 * Java 7 新特性：switch 支持 String
 */
public class Demo03_StringSwitch {

    static String getDayType(String day) {
        switch (day) {
            case "周一": case "周二": case "周三": case "周四": case "周五":
                return "工作日";
            case "周六": case "周日":
                return "周末";
            default:
                return "未知";
        }
    }

    static int monthNumber(String month) {
        switch (month.toLowerCase()) {
            case "january": return 1;   case "february": return 2;
            case "march": return 3;     case "april": return 4;
            case "may": return 5;       case "june": return 6;
            case "july": return 7;      case "august": return 8;
            case "september": return 9; case "october": return 10;
            case "november": return 11; case "december": return 12;
            default: throw new IllegalArgumentException("未知月份: " + month);
        }
    }

    public static void main(String[] args) {
        String[] days = {"周一", "周三", "周六", "周日", "节日"};
        for (String d : days) {
            System.out.println(d + " -> " + getDayType(d));
        }

        System.out.println();
        String[] months = {"January", "March", "June", "December"};
        for (String m : months) {
            System.out.println(m + " -> " + monthNumber(m) + "月");
        }

        // switch(null) 会抛出 NullPointerException
        try {
            getDayType(null);
        } catch (NullPointerException e) {
            System.out.println("\nswitch(null) -> NullPointerException");
        }
    }
}
