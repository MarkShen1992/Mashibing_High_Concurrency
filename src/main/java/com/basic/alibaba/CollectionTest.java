package com.basic.alibaba;

/**
 * 集合处理
 *
 * @author MarkShen1992
 * @since 20200509
 */
public class CollectionTest {
    /*
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        // 判断所有集合内部的元素是否为空，使用 isEmpty()方法
        if (strings.isEmpty()) {
            System.out.println("集合 strings 为空...");
        }

        strings.add("1");
        strings.add("2");
        strings.add("3");

        List<String> strings1 = strings.subList(0, 2);
        strings1.forEach(System.out::println);
        // ArrayList 的 subList 结果不可强转成 ArrayList
        // java.lang.ClassCastException: java.util.ArrayList$SubList cannot be cast to java.util.ArrayList
        // ArrayList<String> arrayList = (ArrayList<String>) strings1;

        // java.lang.UnsupportedOperationException, Returns an empty list (immutable).
        List<Integer> ints = Collections.emptyList();
        // ints.add(1);

        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 6.19));
        pairArrayList.add(new Pair<>("version", 10.24));

        // 在使用 java.util.stream.Collectors 类的 toMap()方法转为 Map 集合时，一定要注意当 value 为 null 时会抛 NPE 异常
        // pairArrayList.add(new Pair<>("version", null));
        Map<String, Double> map = pairArrayList.stream().collect(
        // 生成的 map 集合中只有一个键值对：{version=13.14}
        Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));

        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = list.toArray(new String[0]);
        int length = array.length;
        System.out.println(length);

        // 在使用 Collection 接口任何实现类的 addAll()方法时，都要对输入的集合参数进行 NPE 判断

        //
        Long[] longArr = new Long[] { 1L, 2L, 3L, 4L, 5L, 6L };
        List<Long> longs = Arrays.asList(longArr);
        // longs.add(7L);
        longArr[0] = 11L;

        // PECS(Producer Extends Consumer Super)原则
        // https://itimetraveler.github.io/2016/12/27/%E3%80%90Java%E3%80%91%E6%B3%9B%E5%9E%8B%E4%B8%AD%20extends%20%E5%92%8C%20super%20%E7%9A%84%E5%8C%BA%E5%88%AB%EF%BC%9F/

        // 不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator
        // 方式，如果并发操作，需要对 Iterator 对象加锁。
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.length() > 0) {
                iterator.remove();
            }
        }
    }
    */
}
