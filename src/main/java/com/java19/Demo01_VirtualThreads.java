package com.java19;

import java.util.concurrent.*;

/**
 * Java 19 新特性：虚拟线程 (Virtual Threads)（预览，Java 21 正式化）
 * 轻量级线程，可创建数百万个。需要 JDK 19+ 运行。
 */
public class Demo01_VirtualThreads {

    public static void main(String[] args) throws Exception {
        System.out.println("=== 虚拟线程 (需要 JDK 19+) ===\n");

        // 传统线程池对比
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

        // Java 19+ API
        System.out.println("\nJava 19+ 虚拟线程 API:");
        System.out.println("  Thread.startVirtualThread(() -> { ... });");
        System.out.println("  Thread.ofVirtual().name(\"vt-\", 0).start(() -> { ... });");
        System.out.println("  Executors.newVirtualThreadPerTaskExecutor()");
        System.out.println();
        System.out.println("  try (var exec = Executors.newVirtualThreadPerTaskExecutor()) {");
        System.out.println("      for (int i = 0; i < 100_000; i++) {");
        System.out.println("          exec.submit(() -> { Thread.sleep(100); return fetch(); });");
        System.out.println("      }");
        System.out.println("  }");

        System.out.println("\n虚拟线程 vs 平台线程:");
        System.out.println("  平台: 1MB/线程, 几百~几千个, CPU密集型");
        System.out.println("  虚拟: 几KB/线程, 数百万个, IO密集型");
    }
}
