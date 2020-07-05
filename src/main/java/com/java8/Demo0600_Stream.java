package com.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Stream 01
 * @author MarkShen
 */
public class Demo0600_Stream {
    public static void main(String[] args) {
        /**
        +--------------------+       +------+   +------+   +---+   +-------+
        | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
        +--------------------+       +------+   +------+   +---+   +-------+
         */
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(e -> !e.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);

        System.out.println();

        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        System.out.println();

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);

        List<String> strs = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strs.stream().filter(s -> s.isEmpty()).count();
        System.out.println(count);

        System.out.println();

        Random rdm = new Random();
        rdm.ints().limit(10).sorted().forEach(System.out::println);

        System.out.println();

        List<String> parallelStrings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long countNum = parallelStrings.parallelStream().filter(s -> s.isEmpty()).count();
        System.out.println(countNum);

        System.out.println();

        List<String> ss = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filteredList = ss.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filteredList);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        System.out.println();

        List<Integer> numberList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numberList.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }
}
