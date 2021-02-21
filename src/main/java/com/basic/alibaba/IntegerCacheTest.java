package com.basic.alibaba;

/**
 * IntegerCacheTest
 *
 * @author MarkShen1992
 * @since 2020.5.1
 */
public class IntegerCacheTest {
    public static void main(String[] args) {
        Integer aa = 127;
        Integer bb = 127;
        System.out.println(aa.equals(bb));
        System.out.println(aa == bb);

        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
        System.out.println(a.equals(b));

        int aaa = 128;
        int bbb = 128;
        System.out.println(aaa == bbb);

        Integer c = null;
        Boolean flag = false;
        // a*b 的结果是 int 类型，那么 c 会强制拆箱成 int 类型，抛出 NPE 异常
        Integer result = (flag ? a * b : c);
    }
}
