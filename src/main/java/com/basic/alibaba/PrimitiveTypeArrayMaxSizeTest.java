package com.basic.alibaba;

/**
 * C:\Users\shenjy>java -version java version "1.8.0_112" Java(TM) SE Runtime Environment (build 1.8.0_112-b15) Java
 * HotSpot(TM) 64-Bit Server VM (build 25.112-b15, mixed mode)
 */
public class PrimitiveTypeArrayMaxSizeTest {
    public static void main(String[] args) {
        // JVM 学习站点：
        // 1. http://lovestblog.cn/
        // 2. https://opts.console.heapdump.cn/
        // 3. https://heapdump.cn/

        // 注意：这里使用的虚拟机参数：-Xms9g -Xmx9g
        // Xms: 初始化时候堆大小
        // Xmx: 程序运行时堆大小

        // char[] chars = new char[Integer.MAX_VALUE - 2];
        // System.out.println(chars.length);

        // byte[] bytes = new byte[Integer.MAX_VALUE - 2];
        // System.out.println(bytes.length);

        // short[] shorts = new short[Integer.MAX_VALUE - 2];
        // System.out.println(shorts.length);

        // int[] ints = new int[Integer.MAX_VALUE - 715784195];
        // System.out.println(ints.length);

        // long[] longs = new long[Integer.MAX_VALUE - 1431633921];
        // System.out.println(longs.length);

        // float[] floats = new float[Integer.MAX_VALUE - 715784195];
        // System.out.println(floats.length);

        // double[] doubles = new double[Integer.MAX_VALUE - 1431633921];
        // System.out.println(doubles.length);

        boolean[] booleans = new boolean[Integer.MAX_VALUE - 2];
        System.out.println(booleans.length);
    }
}
