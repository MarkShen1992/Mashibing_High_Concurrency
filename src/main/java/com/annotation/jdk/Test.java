package com.annotation.jdk;

/**
 * @SuppressWarnings suppress v. 抑制，压制，阻止
 * Indicates that the named compiler warnings should be suppressed in the annotated element
 * (and in all program elements contained in the annotated element). Note that the set of warnings
 * suppressed in a given element is a superset of the warnings suppressed in all containing elements.
 * For example, if you annotate a class to suppress one warning and annotate a method to suppress another,
 * both warnings will be suppressed in the method.
 *
 * As a matter of style, programmers should always use this annotation on the most deeply nested element
 * where it is effective. If you want to suppress a warning in a particular method, you should annotate
 * that method rather than its class.
 */
public class Test {
    @SuppressWarnings("deprecation")
    public void sing(String[] args) {
        Person p = new Child();
        p.sing();
    }
}
