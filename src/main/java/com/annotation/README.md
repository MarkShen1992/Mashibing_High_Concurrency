# 按运行机制分类
- 源码注解：注解只在源码中存在，编译成.class文件就不存在了
- 编译时注解：在源码和.class文件中都会存在注解
- 运行时注解：在运行阶段还起作用，甚至韵影像运行逻辑的注解

# 按来源分类
- JDK 中自带的注解
- 第三方的注解
- 我们自定义注解

# 自定义注解
- 自定义注解语法要求
- 注解的注解（元注解）
- 使用自定义注解
- 解析注解

```
package com.sun.org.glassfish.gmbal;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Description { //使用 @interface 来定义注解
    String value(); // 成员以无参无异常方式声明

    String key() default ""; 可以使用 default 为成员指定一个默认值
}
```
> 成员的类型是受限制的，合法的类型包括Java基本类型及 String, Class, Annotation, Enumeration
> 
> 如果注解只有一个成员，则成员名必须取名为value(), 在使用时可以忽略成员名和赋值号(=)
>
> 注解类可以没有成员，没有成员的注解可以被称为标识注解

## 元注解
```
public enum ElementType {
    /** Class, interface (including annotation type), or enum declaration */
    TYPE,

    /** Field declaration (includes enum constants) */
    FIELD,

    /** Method declaration */
    METHOD,

    /** Formal parameter declaration */
    PARAMETER,

    /** Constructor declaration */
    CONSTRUCTOR,

    /** Local variable declaration */
    LOCAL_VARIABLE,

    /** Annotation type declaration */
    ANNOTATION_TYPE,

    /** Package declaration */
    PACKAGE,

    /**
     * Type parameter declaration
     *
     * @since 1.8
     */
    TYPE_PARAMETER,

    /**
     * Use of a type
     *
     * @since 1.8
     */
    TYPE_USE
}
```
```
public enum RetentionPolicy {
    /**
     * Annotations are to be discarded by the compiler.
     */
    SOURCE,

    /**
     * Annotations are to be recorded in the class file by the compiler
     * but need not be retained by the VM at run time.  This is the default
     * behavior.
     */
    CLASS,

    /**
     * Annotations are to be recorded in the class file by the compiler and
     * retained by the VM at run time, so they may be read reflectively.
     *
     * @see java.lang.reflect.AnnotatedElement
     */
    RUNTIME
}
```

```
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Inherited {
}

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Documented {
}
```

## 自定义注解使用
```
package com.annotation.own;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {

    String value();

    String desc();

    String author();

    int age() default 18;
}
```

# 解析注解
- 通过**反射**获取类，函数或成员上的运行时注解信息，从而实现动态控制程序运行逻辑
