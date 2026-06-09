package com.java21;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Java 21 新特性（LTS）：虚拟线程（正式化）
 * 轻量级线程，可创建数百万个。需要 JDK 21 运行。
 */
public class Demo03_VirtualThread {

    public static void main(String[] args) throws Exception {
        // 传统线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        var futures = new java.util.ArrayList<Future<Integer>>();
        for (int i = 0; i < 100; i++) {
            final int id = i;
            futures.add(pool.submit(() -> { Thread.sleep(50); return id; }));
        }
        for (var f : futures) f.get();
        pool.shutdown();
        System.out.println("平台线程池(10线程) 100任务: " + (System.currentTimeMillis() - start) + "ms");

        // Java 21 虚拟线程 API
        System.out.println("\n=== Java 21 虚拟线程（正式化）===");
        System.out.println();
        System.out.println("// 创建");
        System.out.println("Thread.ofVirtual().name(\"vt-\", 0).start(() -> { ... });");
        System.out.println("Thread.startVirtualThread(() -> { ... });");
        System.out.println();
        System.out.println("// Executor（推荐）");
        System.out.println("try (var exec = Executors.newVirtualThreadPerTaskExecutor()) {");
        System.out.println("    IntStream.range(0, 1_000_000).forEach(i ->");
        System.out.println("        exec.submit(() -> { Thread.sleep(100); return fetch(); })");
        System.out.println("    );");
        System.out.println("}");
        System.out.println();
        System.out.println("最佳实践:");
        System.out.println("  1. 不池化（用完即弃）");
        System.out.println("  2. 适合 IO 密集型");
        System.out.println("  3. 用 ReentrantLock 替代 synchronized");
        System.out.println("  4. try-with-resources 管理 Executor");
    }
}
