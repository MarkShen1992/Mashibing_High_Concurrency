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
    }
}
