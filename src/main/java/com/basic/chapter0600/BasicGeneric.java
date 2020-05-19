package com.basic.chapter0600;

import java.util.*;

/**
 * Java 泛型底层:
 * https://www.cnblogs.com/liang1101/p/6407871.html
 *
 * @author MarkShen
 * @since 20191221
 */
public class BasicGeneric {
    public static void main(String[] args) {
        /**
         * 泛型起因：
         *  JDK1.4以前类型不明确
         *      装入集合的类型被当作Object被对待，从而失去自己实际的类型
         *      从集合中取出时往往需要转型，效率低，容易产生错误
         * 解决方法：
         *  在定义集合的时候，同时定义集合中元素的类型
         *      可在定义Collection的时候指定
         *      也可在循环时用Iterator指定
         *
         * 好处：
         *  增强程序的可读性和稳定性
         */
        // 有序可以重复
        List<String> c = new ArrayList<String>();
        c.add("aaa");
        c.add("bbb");
        c.add("ccc");
        for (int i = 0; i < c.size(); i++) {
            String s = c.get(i);
            System.out.println(s);
        }
        c.add(1, "insert");
        System.out.println();
        for (String s : c) {
            System.out.println(s);
        }

        Collection<String> c2 = new HashSet<String>();
        c2.add("aaa");
        c2.add("bbb");
        c2.add("ccc");
        for (Iterator<String> it = c2.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
    }
}

class MyName implements Comparable<MyName> {
    int age;

    public int compareTo(MyName mn) {
        if (this.age > mn.age) return 1;
        else if (this.age < mn.age) return -1;
        else return 0;
    }
}

