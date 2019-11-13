package com.basic.chapter0200;

/**
 * this 关键字
 * 在类的方法定义中使用的this关键字代表使用该方法的对象的引用
 * 当必须指定当前使用方法的对象是谁的时候用this
 * 使用this处理类中构造方法中，成员变量和参数重名的问题
 * 当前对象的引用
 *
 * @author MarkShen1992
 * @since 20191113
 */
public class Chapter0207this {

    int i = 0;

    /**
     * 原则：当你确定不了一个参数到底是哪个变量的时候，找离他最近的声明
     *
     */
    public Chapter0207this(int i) {
        this.i = i;
    }

    /**
     * 链式编程
     * 返回值在栈空间分配
     *
     * @return
     */
    public Chapter0207this increment() {
        i ++;
        return this;
    }

    public void print() {
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Chapter0207this c = new Chapter0207this(1);
        c.increment().increment().print();
    }
}
