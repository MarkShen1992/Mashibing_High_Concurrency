package com.java11;

/**
 * Java 11 新特性：String 新方法
 * isBlank(), lines(), strip(), stripLeading(), stripTrailing(), repeat()
 */
public class Demo02_StringMethods {

    public static void main(String[] args) {
        // isBlank()
        System.out.println("\"\".isBlank() = " + "".isBlank());
        System.out.println("\"  \".isBlank() = " + "  ".isBlank());
        System.out.println("\"Hi\".isBlank() = " + "Hi".isBlank());

        // lines()
        String text = "第一行\n第二行\n第三行";
        System.out.println("\nlines() 行数: " + text.lines().count());
        text.lines().forEach(line -> System.out.println("  -> " + line));

        // strip() vs trim()
        String s = "  Hello  ";
        System.out.println("\nstrip(): [" + s.strip() + "]");
        System.out.println("stripLeading(): [" + s.stripLeading() + "]");
        System.out.println("stripTrailing(): [" + s.stripTrailing() + "]");

        // Unicode 全角空格
        char fullSpace = '\u3000';
        String uni = fullSpace + "测试" + fullSpace;
        System.out.println("\ntrim():  [" + uni.trim() + "]  (不去全角空格)");
        System.out.println("strip(): [" + uni.strip() + "] (去全角空格)");

        // repeat()
        System.out.println("\n\"ha\".repeat(3) = " + "ha".repeat(3));
        System.out.println("\"-\".repeat(20) = " + "-".repeat(20));

        // 综合：处理 CSV
        String csv = "姓名,年龄\n张三,25\n\n李四,30\n";
        System.out.println("\nCSV 有效行:");
        csv.lines().filter(l -> !l.isBlank()).skip(1)
                .map(String::strip)
                .forEach(l -> System.out.println("  " + l));
    }
}
