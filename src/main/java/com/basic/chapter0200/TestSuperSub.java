package com.basic.chapter0200;

class SuperClass {
    private int n;

    SuperClass() {
        System.out.println("SuperClass()");
    }

    SuperClass(int n) {
        System.out.println("SuperClass(" + n + ")");
        this.n = n;
    }
}

class SubClass extends SuperClass {
    private int n;

    SubClass(int n) {
        super();
        System.out.println("SubClass(" + n + ")");
        this.n = n;
    }

    SubClass() {
        super(300);
        System.out.println("SubClass()");
    }
}

/**
 * 继承中的构造方法
 *   规则：
 *   1. 子类在构造的时候，要首先调用父类的构造方法
 *   2. super 关键字
 *   3. 如果调用了 super，必须写在子类构造方法的第一行
 *
 * @author MarkShen1992
 * @since 继承中的构造方法
 */
public class TestSuperSub {
    public static void main(String arg[]) {
        SubClass sc1 = new SubClass();
        SubClass sc2 = new SubClass(400);
    }
}

