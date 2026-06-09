package com.java25;

/**
 * Java 25 新特性（LTS）
 * Java 25 是下一个长期支持版本，预计正式化 Java 22-24 的预览特性。
 */
public class Demo01_ScopedValues {

    // 作用域值 ScopedValue（替代 ThreadLocal）
    // final static ScopedValue<String> USER = ScopedValue.newInstance();
    //
    // void handleRequest(String user) {
    //     ScopedValue.runWhere(USER, user, () -> {
    //         processOrder();  // 子方法中可通过 USER.get() 获取
    //     });
    // }

    public static void main(String[] args) {
        System.out.println("=== Java 25 (LTS) 预计正式化的特性 ===\n");

        System.out.println("1. 灵活的构造函数体 - 预计正式化");
        System.out.println("2. 作用域值 (Scoped Values) - 预计正式化");
        System.out.println("3. 结构化并发 (Structured Concurrency) - 预计正式化");
        System.out.println("4. 简单源文件和实例 main - 预计正式化");
        System.out.println("5. Class-File API - 预计正式化");
        System.out.println("6. 模块导入声明 - 预计正式化或继续预览");

        System.out.println("\n=== 作用域值 vs ThreadLocal ===");
        System.out.println("ThreadLocal 问题:");
        System.out.println("  - 可变（随时 set），易出错");
        System.out.println("  - 内存泄漏风险（忘记 remove）");
        System.out.println("  - 子线程可能看到过时值");
        System.out.println("\nScopedValue 优势:");
        System.out.println("  - 不可变（绑定后不修改）");
        System.out.println("  - 自动生命周期管理");
        System.out.println("  - 与虚拟线程配合，性能更优");

        System.out.println("\n=== 结构化并发 ===");
        System.out.println("  try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {");
        System.out.println("      Subtask<User> user = scope.fork(() -> findUser(id));");
        System.out.println("      Subtask<Order> order = scope.fork(() -> fetchOrder(id));");
        System.out.println("      scope.join().throwIfFailed();");
        System.out.println("      return new Response(user.get(), order.get());");
        System.out.println("  }  // 退出时自动取消未完成子任务");
    }
}
