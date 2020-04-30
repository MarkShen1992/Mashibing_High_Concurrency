package com.basic.alibaba;

/**
 * IntegerCacheTest
 *
 * @author MarkShen1992
 * @since 2020.5.1
 */
public class IntegerCacheTest {
    public static void main(String[] args) {
        Integer aa = 120;
        Integer bb = 120;
        System.out.println(aa.equals(bb));
        System.out.println(aa == bb);

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
