package com.java8;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 02
 * @author MarkShen
 * https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/index.html
 */
public class Demo0700_Stream {
    public static void main(String[] args) {
        /**
         * how to build stream
         */
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");

        // 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);

        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

        /**
         * number stream build
         */
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        /**
         * other data structure from stream
         */
        String[] strArr = {"a", "b", "c"};
        // 1. Array, List, Set, Stack, String
        String[] sArr = Arrays.stream(strArr).toArray(String[]::new);
        List<String> list1 = Arrays.stream(strArr).collect(Collectors.toList());
        List<String> list2 = Arrays.stream(strArr).collect(Collectors.toCollection(ArrayList::new));
        Set<String> set1 = Arrays.stream(strArr).collect(Collectors.toSet());
        Stack<String> stack1 = Arrays.stream(strArr).collect(Collectors.toCollection(Stack::new));
        String str = Arrays.stream(strArr).collect(Collectors.joining(", "));

        // convert all elements to upper case
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream()
                .filter(e -> e.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);

        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        outputStream.forEach(System.out::println);

        System.out.println();

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        System.out.println();

        Stream.of("one", "two", "three", "four")
                .findFirst().ifPresent(System.out::println);

        System.out.println();

        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);

        System.out.println();

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .limit(3)
                .skip(2)
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println();

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            people.add(new Person(i, "name" + i));
        }
        people.add(new Person(10, "name0"));

        // 根据 name 属性降序输出
        people.stream()
                .sorted(Comparator.comparing(Person::getName).reversed())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Map<String, List<Person>> result = people.stream()
                .collect(Collectors.groupingBy(Person::getName));
        System.out.println(result);

        long c = people.stream().filter(x -> x.getId() > 5).count();
        System.out.println(c);

        long resultNum = people.stream().map(Person::getName).distinct().count();
        System.out.println(resultNum);

        Optional<Person> min = people.stream().min(Comparator.comparing(Person::getId));
        System.out.println(min.get());

        Optional<Person> max = people.stream().max(Comparator.comparing(Person::getId));
        max.ifPresent(System.out::println);

        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
        // Another way
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
                limit(10).forEach(System.out::println);

        Stream.iterate(0, n -> n + 3).limit(10). forEach(x -> System.out.print(x + " "));

        Map<Boolean, List<Person>> resultMap = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getId() < 6));
        System.out.println(resultMap);
    }
}