package com.basic.chapter0600;

import java.util.*;

/**
 * 三流的公司卖产品
 * 二流的公司卖服务
 * 一流的公司卖标准
 */
public class BasicContainer {
    public static void main(String[] args) {
        // 无序不可以重复
        Collection c = new HashSet();
        c.add("hello");
        c.add(new Name("f1", "l1"));
        c.add(new Integer(100));
        c.remove("hello");
        c.remove(new Integer(100));
        System.out.println(c.remove(new Name("f1", "l1")));
        System.out.println(c);
    }
}

class Name implements Comparable {
    private String firstName, lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     * 如果两个对象 equals, 那么这两个对象的hashcode相等
     *
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if (obj instanceof Name) {
            Name name = (Name) obj;
            return (firstName.equals(name.firstName))
                    && (lastName.equals(name.lastName));
        }
        return super.equals(obj);
    }

    /**
     * 使用场景：
     * 当这个对象用在Map接口里里面作为 key 的时候需要用到 hashCode().
     * 相等的对象应该具有享同的hash code, 非常适合做 索引。对象作为索引的时候
     * <p>
     * 原则：重写一个对象的 equals方法时，必须同时重写 hashCode方法
     * 两个对象 equals，两个对象必须拥有相同的 hashcode.
     * <p>
     * 扩展：hashcode算法
     *
     * @return
     */
    public int hashCode() {
        return firstName.hashCode();
    }

    public int compareTo(Object o) {
        Name n = (Name) o;
        int lastCmp = lastName.compareTo(n.lastName);
        return lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName);
    }

}
