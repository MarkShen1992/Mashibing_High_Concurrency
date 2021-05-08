package com.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author MarkShen
 * @since 20210509
 */
public class CollectionIterate {

    public static void main(String[] args) {
        // 集合遍历方法之 List Set
        List<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("b");
        strs.add("c");
        strs.add("d");
        strs.add("f");
        strs.add("g");

        // 01
        for (int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }

        // 02
        for (String str : strs) {
            System.out.println(str);
        }

        // 03
        Iterator it = strs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 04
        strs.stream().forEach(s -> System.out.println(s));

        // 集合遍历方法之 Map
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");

        // 01
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey + ":" + mapValue);
        }

        // 02
        Iterator<Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Entry<String, String> entry = entries.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }

}
