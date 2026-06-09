package com.java7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Java 7 新特性：try-with-resources
 * 自动关闭实现了 AutoCloseable 接口的资源。
 */
public class Demo01_TryWithResources {

    public static void main(String[] args) throws IOException {
        String file = "try_demo.txt";

        // 写文件
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Hello Java 7!\n第二行\n");
        }

        // 读文件 - 自动关闭
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        // 多资源 try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             FileWriter writer = new FileWriter("try_demo_copy.txt")) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase() + "\n");
            }
        }

        // 自定义 AutoCloseable
        try (MyResource res = new MyResource("数据库连接")) {
            res.doWork();
        }

        new java.io.File(file).delete();
        new java.io.File("try_demo_copy.txt").delete();
    }

    static class MyResource implements AutoCloseable {
        private final String name;
        MyResource(String name) { this.name = name; System.out.println("打开: " + name); }
        void doWork() { System.out.println("使用 " + name + " 工作中..."); }
        @Override public void close() { System.out.println("自动关闭: " + name); }
    }
}
