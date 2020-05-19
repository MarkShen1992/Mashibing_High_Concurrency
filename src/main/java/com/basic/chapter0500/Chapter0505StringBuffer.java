package com.basic.chapter0500;

/**
 * StringBuffer
 *
 * @author MarkShen
 * @since 20191129
 */
public class Chapter0505StringBuffer {
    public static void main(String[] args) {
        String s = "Microsoft";
        char[] a = {'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder(s);
        sb.append("/").append("IBM")
                .append("/").append("Sun");
        sb.insert(0, a);
        System.out.println(sb);
        System.out.println(sb.reverse());
    }
}
