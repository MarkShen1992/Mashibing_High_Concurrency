package com.basic.chapter0600;

import java.util.*;

public class TestArgsWords2 {
    private static final int ONE = 1;

    public static void main(String args[]) {
        Map<String, Integer> m = new HashMap<String, Integer>();
        for (int i = 0; i < args.length; i++) {

            if (!m.containsKey(args[i])) {
                m.put(args[i], ONE);
            } else {
                int freq = m.get(args[i]);
                m.put(args[i], freq + 1);
            }

        }
        System.out.println(m.size() + " distinct words detected:");
        System.out.println(m);

        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }
}
