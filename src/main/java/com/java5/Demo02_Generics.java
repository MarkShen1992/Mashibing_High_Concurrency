package com.java5;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 5 新特性：泛型 (Generics)
 */
public class Demo02_Generics {

    static class Box<T> {
        private T value;
        Box(T value) { this.value = value; }
        T get() { return value; }
        void set(T value) { this.value = value; }
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;
        Pair(K key, V value) { this.key = key; this.value = value; }
        K getKey() { return key; }
        V getValue() { return value; }
    }

    public static <T> void printArray(T[] array) {
        for (T item : array) System.out.print(item + " ");
        System.out.println();
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static void main(String[] args) {
        // 泛型类
        Box<Integer> intBox = new Box<>(42);
        Box<String> strBox = new Box<>("Hello");
        System.out.println("intBox: " + intBox.get());
        System.out.println("strBox: " + strBox.get());

        // 泛型方法
        printArray(new Integer[]{1, 2, 3});
        printArray(new String[]{"a", "b", "c"});

        // 类型推断
        System.out.println("max(3, 7) = " + max(3, 7));
        System.out.println("max(\"apple\", \"banana\") = " + max("apple", "banana"));

        // 上界通配符 ? extends
        List<Integer> ints = new ArrayList<>();
        ints.add(1); ints.add(2); ints.add(3);
        System.out.println("sum = " + sumOfList(ints));

        // 下界通配符 ? super
        List<Number> nums = new ArrayList<>();
        addIntegers(nums);
        System.out.println("nums = " + nums);

        // 多类型参数
        Pair<String, Integer> pair = new Pair<>("age", 25);
        System.out.println(pair.getKey() + "=" + pair.getValue());
    }

    static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) sum += n.doubleValue();
        return sum;
    }

    static void addIntegers(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) list.add(i);
    }
}
