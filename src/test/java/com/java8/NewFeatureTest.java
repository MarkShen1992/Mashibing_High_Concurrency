package com.java8;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java 8 New feature test
 */
public class NewFeatureTest extends TestCase {

    @Test
    public void testLambda01() {
        // () -> 3.14
        // (value) -> (value % 2) == 0

        // Lambda 表达式是匿名内部类的一种简化
        MyVal myVal = () -> 3.14;
        System.out.println(myVal.getVal());

        ValidEvenNum validEvenNum = (value) -> (value % 2) == 0;
        System.out.println(validEvenNum.isEven(10));
    }

    @Test
    public void testLambda02() {
        MyVal myVal = new MyVal() {
            @Override
            public double getVal() {
                return 3.14;
            }
        };
        System.out.println(myVal.getVal());
    }

    @Test
    public void testLambda03() {
        // Lambda 表达式和匿名内部类的应用，字符串的逆序输出 之
        // IN: abcdefg OUT: gfedcba
        display("abcdefg", new MyFunctionalInterface() {
            @Override
            public String reverse(String s) {
                StringBuilder sb = new StringBuilder();
                char[] chars = s.toCharArray();
                for (int i = chars.length - 1; i >= 0; i--) {
                    sb.append(chars[i]);
                }
                return sb.toString();
            }
        });
    }

    @Test
    public void testLambda04() {
        // Lambda 表达式和匿名内部类的应用，字符串的逆序输出 之
        // IN: abcdefg OUT: gfedcba
        display("abcdefg", (s) -> {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            return sb.toString();
        });
    }

    public void display(String s, MyFunctionalInterface myFunctionalInterface) {
        System.out.println(myFunctionalInterface.reverse(s));
    }

    interface MyFunctionalInterface {
        String reverse(String s);
    }

    interface MyVal {
        double getVal();
    }

    interface ValidEvenNum {
        boolean isEven(int num);
    }

    // ===============================================================
    // https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
    @Test
    public void testLambda05() {
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        stream.forEach(System.out::print);
        System.out.println();
        // 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream.forEach(System.out::print);
        System.out.println();

        stream = Arrays.stream(strArray);
        stream.forEach(System.out::print);
        System.out.println();

        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
        stream.forEach(System.out::print);
    }

    /**
     * 数值流的构造
     */
    @Test
    public void testLambda06() {
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::print);
        System.out.println();
        IntStream.range(1, 3).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1, 3).forEach(System.out::print);
    }
}
