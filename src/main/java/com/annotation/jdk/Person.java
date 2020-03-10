package com.annotation.jdk;

/**
 * Java 注解从 Java 5开始
 * @Deprecated 已过时；被废弃
 * A program element annotated @Deprecated is one that programmers are discouraged from using,
 * typically because it is dangerous, or because a better alternative exists. Compilers warn
 * when a deprecated program element is used or overridden in non-deprecated code.
 */
public interface Person {

    public String name();

    public int age();

    @Deprecated
    public void sing();
}
