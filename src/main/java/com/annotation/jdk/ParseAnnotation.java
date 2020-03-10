package com.annotation.jdk;

import com.annotation.own.Description;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnnotation {
    public static void main(String[] args) {
        // 1. 使用类加载器加载类
        try {
            Class c = Class.forName("com.annotation.jdk.Child");

            // 2. 找到类上的注解
            boolean flag = c.isAnnotationPresent(Description.class);
            if (flag) {
                // 3. 拿到注解实例
                Description description = (Description) c.getAnnotation(Description.class);
                System.out.println(description.value());
            }

            // 4. 找到方法上的注解
            Method[] ms = c.getMethods();
            for (Method m : ms) {
                boolean annotationPresent = m.isAnnotationPresent(Description.class);
                if (annotationPresent) {
                    Description description = m.getAnnotation(Description.class);
                    System.out.println(description.value());
                }
            }

            // 5. 另一种解析方法
            for (Method m : ms) {
                Annotation[] as = m.getAnnotations();
                for (Annotation a : as) {
                    if (a instanceof Description) {
                        Description description = (Description) a;
                        System.out.println(description.value());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}