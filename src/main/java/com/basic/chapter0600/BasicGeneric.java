package com.basic.chapter0600;

import java.util.*;

public class BasicGeneric {
    public static void main(String[] args) {
        // 有序可以重复
        List<String> c = new ArrayList<String>();
        c.add("aaa");
        c.add("bbb");
        c.add("ccc");
        for (int i = 0; i < c.size(); i++) {
            String s = c.get(i);
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

