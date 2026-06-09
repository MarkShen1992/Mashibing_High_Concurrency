package com.java5;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * Java 5 新特性：注解 (Annotation / Metadata)
 */
public class Demo03_Annotation {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface MyAnnotation {
        String author() default "Unknown";
        String date();
        double version() default 1.0;
    }

    @MyAnnotation(author = "张三", date = "2024-01-01", version = 2.0)
    public static void myMethod() {
        System.out.println("被注解标记的方法");
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface FieldInfo {
        String value();
        int maxLength() default 255;
    }

    static class User {
        @FieldInfo(value = "用户名", maxLength = 50)
        String name;
        @FieldInfo("邮箱")
        String email;
        User(String name, String email) { this.name = name; this.email = email; }
    }

    public static void main(String[] args) throws Exception {
        // 读取方法注解
        for (Method m : Demo03_Annotation.class.getDeclaredMethods()) {
            MyAnnotation ann = m.getAnnotation(MyAnnotation.class);
            if (ann != null) {
                System.out.printf("方法: %s, author=%s, date=%s, version=%.1f%n",
                        m.getName(), ann.author(), ann.date(), ann.version());
            }
        }

        // 读取字段注解
        User user = new User("zhangsan", "zhang@test.com");
        for (java.lang.reflect.Field f : user.getClass().getDeclaredFields()) {
            FieldInfo info = f.getAnnotation(FieldInfo.class);
            if (info != null) {
                f.setAccessible(true);
                System.out.printf("字段: %s, 描述: %s, maxLength: %d, 值: %s%n",
                        f.getName(), info.value(), info.maxLength(), f.get(user));
            }
        }
    }
}
