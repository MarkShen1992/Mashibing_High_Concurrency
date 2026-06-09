package com.java11;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Java 11 新特性：Files.readString() / Files.writeString()
 */
public class Demo03_FilesReadWrite {

    public static void main(String[] args) throws IOException {
        Path dir = Files.createTempDirectory("java11");

        // writeString - 一行写文件
        Path file = dir.resolve("hello.txt");
        Files.writeString(file, "Hello Java 11!\nFiles.writeString 真方便!");
        System.out.println("已写入: " + file + " (" + Files.size(file) + " bytes)");

        // readString - 一行读文件
        String content = Files.readString(file);
        System.out.println("内容:\n" + content);

        // 指定字符集
        Path utf8 = dir.resolve("utf8.txt");
        Files.writeString(utf8, "你好世界", StandardCharsets.UTF_8);
        System.out.println("UTF-8: " + Files.readString(utf8, StandardCharsets.UTF_8));

        // 追加写入
        Path log = dir.resolve("app.log");
        Files.writeString(log, "第1行日志\n");
        Files.writeString(log, "第2行日志\n", StandardOpenOption.APPEND);
        Files.writeString(log, "第3行日志\n", StandardOpenOption.APPEND);
        System.out.println("\n日志:\n" + Files.readString(log));

        // 对比
        System.out.println("Java 11 之前: Files.write(path, \"text\".getBytes(UTF_8))");
        System.out.println("Java 11:      Files.writeString(path, \"text\")");

        // 清理
        Files.deleteIfExists(file);
        Files.deleteIfExists(utf8);
        Files.deleteIfExists(log);
        Files.deleteIfExists(dir);
    }
}
