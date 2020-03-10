package com.annotation.jdk;

import com.annotation.own.Description;

/**
 * @Override 这个注解 告诉编译器 / 程序员，方法覆盖接口中方法
 * Indicates that a method declaration is intended to override a method declaration in a supertype.
 * If a method is annotated with this annotation type compilers are required to generate an error
 * message unless at least one of the following conditions hold:
 *
 * The method does override or implement a method declared in a supertype.
 * The method has a signature that is override-equivalent to that of any public method declared in Object.
 */
@Description("I am a class annotation.")
public class Child implements Person {

    @Override
    @Description("I am a method annotation.")
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {

    }
}
