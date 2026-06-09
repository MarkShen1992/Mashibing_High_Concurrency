package com.java5;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 5 新特性：自动装箱与拆箱 (Autoboxing / Unboxing)
 */
public class Demo05_Autoboxing {

    public static void main(String[] args) {
        // 自动装箱: int -> Integer
        Integer a = 100;       // 等价于 Integer.valueOf(100)
        Integer b = 200;

        // 自动拆箱: Integer -> int
        int x = a;             // 等价于 a.intValue()

        // 算术运算中的自动装箱拆箱
        Integer sum = a + b;   // 拆箱运算后再装箱
        System.out.println(a + " + " + b + " = " + sum);

        // 集合中的自动装箱（Java 5 之前必须用包装类型）
        List<Integer> list = new ArrayList<>();
        list.add(1);           // 自动装箱
        list.add(2);
        list.add(3);
        int first = list.get(0);  // 自动拆箱
        System.out.println("列表: " + list + ", 第一个(拆箱): " + first);

        // Integer 缓存（-128 到 127）
        Integer i1 = 127, i2 = 127;
        Integer i3 = 128, i4 = 128;
        System.out.println("127 == 127: " + (i1 == i2));   // true（缓存范围内）
        System.out.println("128 == 128: " + (i3 == i4));   // false（超出缓存）
        System.out.println("128 equals 128: " + i3.equals(i4));  // true

        // 拆箱 null 值导致 NPE
        try {
            Integer nullInt = null;
            int danger = nullInt;  // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("拆箱 null 值 -> NullPointerException");
        }
    }
}
