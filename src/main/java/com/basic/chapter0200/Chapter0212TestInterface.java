package com.basic.chapter0200;

/**
 * 接口测试
 *
 * @author MarkShen1992
 * @since 20191120
 */
public class Chapter0212TestInterface implements A, B {
    public static void main(String[] args) {
        Chapter0212TestInterface t = new Chapter0212TestInterface();
        t.print();

        A a = new Chapter0212TestInterface();
        t.print(a);
    }

    @Override
    public void print() {
        System.out.println("hello world!");
    }

    @Override
    public void print(A a) {
        System.out.println(a);
    }
}

interface A {
    void print();
}

interface B {
    void print(A a);
}

interface C {
    void test();
}

interface D extends C, A, B {
    void test();
    void sleep();
    void sing();
}