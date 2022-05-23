package com.java8;

import java.util.*;
import java.util.stream.Collectors;

public class Demo0800_Stream {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person(1, "Bob", 21, 1), new Person(2, "Alice", 25, 0),
            new Person(4, "Calvin", 26, 1), new Person(3, "Susan", 34, 0), new Person(5, "Trump", 70, 1));

        Person persion = persons.stream().filter(p -> p.getName().equals("Bob")).findFirst().orElse(null);
        System.out.println(persion);

        // 人小于等于25的人的名字
        List<String> names =
            persons.stream().filter(p -> p.getAge() <= 25).map(Person::getName).collect(Collectors.toList());

        System.out.println(names);

        // 分页查询实现
        int pageIndex = 1;
        int pageSize = 2;
        int recordIndex = (pageIndex - 1) * pageSize;
        List<Person> pagedPerson = persons.stream().skip(recordIndex) // 每页第一条数据的位置
            .limit(pageSize) // 页面大小
            .collect(Collectors.toList());

        System.out.println(pagedPerson);

        // Searching
        Optional<Person> any = persons.stream().filter(p -> p.getAge() < 25).findAny();

        System.out.println(any);
        System.out.println(persons.stream().anyMatch(p -> p.getAge() < 25));

        // Reordering Descending
        List<Person> sortedPersons = persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()) // 升序
            .collect(Collectors.toList());

        System.out.println(sortedPersons);

        // Summarizing
        int sum = 0;
        sum = persons.stream().mapToInt(Person::getAge).reduce(0, (total, currentVal) -> total + currentVal);
        System.out.println(sum);

        sum = persons.stream().mapToInt(Person::getAge).sum();
        System.out.println(sum);

        long count = 0;
        count = persons.stream().mapToInt(Person::getAge).count();
        System.out.println(count);

        // calculating summary
        IntSummaryStatistics ageStatistics = persons.stream().mapToInt(Person::getAge).summaryStatistics();
        System.out.println(ageStatistics.getAverage());
        System.out.println(ageStatistics.getCount());
        System.out.println(ageStatistics.getMax());
        System.out.println(ageStatistics.getMin());
        System.out.println(ageStatistics.getSum());

        // Grouping
        Map<Integer, List<Person>> peopleGroupBySex =
            persons.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.toList()));
        System.out.println(peopleGroupBySex);

        Map<Integer, List<String>> nameByGender = persons.stream()
            .collect(Collectors.groupingBy(Person::getSex, Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(nameByGender);

        Map<Integer, Double> averageAgeByGender =
            persons.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.averagingInt(Person::getAge)));
        System.out.println(averageAgeByGender);
    }
}
