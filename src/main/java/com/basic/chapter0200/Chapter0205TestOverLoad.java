package com.basic.chapter0200;

/**
 * 练习例子
 *
 * @author MarkShen1992
 * @since 20191107
 */
public class Chapter0205TestOverLoad {
    public static void main(String[] args) {
        Person p = new Person();
        Person p1 = new Person(400);
        Person p2 = new Person(2, 500);
        p.info();
        p.info("ok");
    }
}

class Person {

    Person() {
        id = 0;
        age = 20;
    }

    Person(int _id) {
        id = _id;
        age = 23;
    }

    Person(int _id, int _age) {
        id = _id;
        age = _age;
    }

    // 成员变量定义
    private int id;
    private int age = 20;

    // 方法定义
    public int getAge() {
        return age;
    }

    public void setAge(int i) {
        age = i;
    }

    public int getId() {
        return id;
    }

    void info() {
        System.out.println("my id is : " + id);
    }

    void info(String t) {
        System.out.println(t + " id " + id);
    }
}