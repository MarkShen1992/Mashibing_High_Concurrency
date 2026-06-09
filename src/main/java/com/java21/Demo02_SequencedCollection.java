package com.java21;

import java.util.*;

/**
 * Java 21 新特性（LTS）：有序集合 SequencedCollection / SequencedSet / SequencedMap
 * 统一的首尾元素访问和逆序视图 API。需要 JDK 21 运行。
 */
public class Demo02_SequencedCollection {

    public static void main(String[] args) {
        // Java 21 之前的方式
        List<String> list = new ArrayList<>(List.of("Java", "21", "新特性", "有序集合"));
        System.out.println("第一个: " + list.get(0));
        System.out.println("最后一个: " + list.get(list.size() - 1));

        LinkedList<String> ll = new LinkedList<>(list);
        ll.addFirst(">>>"); ll.addLast("<<<");
        System.out.println("LinkedList 首尾: " + ll);

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("语文", 90); map.put("数学", 95); map.put("英语", 88);
        System.out.println("Map: " + map);

        // Java 21 API
        System.out.println("\n=== Java 21 新增 API ===");
        System.out.println("SequencedCollection:");
        System.out.println("  getFirst() / getLast()");
        System.out.println("  addFirst(e) / addLast(e)");
        System.out.println("  removeFirst() / removeLast()");
        System.out.println("  reversed()");
        System.out.println("\nSequencedSet:");
        System.out.println("  继承 SequencedCollection");
        System.out.println("  reversed() 返回 SequencedSet");
        System.out.println("\nSequencedMap:");
        System.out.println("  firstEntry() / lastEntry()");
        System.out.println("  putFirst(k,v) / putLast(k,v)");
        System.out.println("  pollFirstEntry() / pollLastEntry()");
        System.out.println("  reversed()");

        System.out.println("\n=== Java 21 代码示例 ===");
        System.out.println("SequencedCollection<String> list = new ArrayList<>(...);");
        System.out.println("list.getFirst();       list.getLast();");
        System.out.println("list.addFirst(\">>>\");  list.addLast(\"<<<\");");
        System.out.println("list.reversed();");
        System.out.println();
        System.out.println("SequencedMap<String, Integer> map = new LinkedHashMap<>();");
        System.out.println("map.firstEntry();      map.lastEntry();");
        System.out.println("map.putFirst(k, v);    map.reversed();");
    }
}
