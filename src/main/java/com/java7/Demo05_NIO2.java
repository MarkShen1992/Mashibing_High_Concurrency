package com.java7;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Java 7 新特性：NIO.2 文件系统 API
 */
public class Demo05_NIO2 {

    public static void main(String[] args) throws IOException {
        // Path
        Path path = Paths.get("nio2_demo", "sub", "test.txt");
        System.out.println("路径: " + path);
        System.out.println("文件名: " + path.getFileName());
        System.out.println("父目录: " + path.getParent());

        // 创建目录和文件
        Path dir = Paths.get("nio2_demo");
        Path sub = dir.resolve("sub");
        Files.createDirectories(sub);

        Path file = sub.resolve("test.txt");
        Files.write(file, "Hello NIO.2!\n第二行".getBytes(StandardCharsets.UTF_8));
        System.out.println("文件大小: " + Files.size(file) + " bytes");

        // 读取
        List<String> lines = Files.readAllLines(file, StandardCharsets.UTF_8);
        System.out.println("所有行: " + lines);

        // 文件属性
        System.out.println("常规文件: " + Files.isRegularFile(file));
        System.out.println("可读: " + Files.isReadable(file));

        // 文件复制
        Path copy = dir.resolve("copy.txt");
        Files.copy(file, copy, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("已复制到: " + copy.getFileName());

        // 递归遍历
        System.out.println("\n递归遍历:");
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path f, BasicFileAttributes a) {
                System.out.println("  文件: " + f + " (" + a.size() + "b)");
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult preVisitDirectory(Path d, BasicFileAttributes a) {
                System.out.println("  目录: " + d);
                return FileVisitResult.CONTINUE;
            }
        });

        // 清理
        Files.deleteIfExists(copy);
        Files.deleteIfExists(file);
        Files.deleteIfExists(sub);
        Files.deleteIfExists(dir);
    }
}
