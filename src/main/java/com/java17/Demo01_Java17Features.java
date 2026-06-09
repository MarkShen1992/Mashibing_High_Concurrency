package com.java17;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * Java 17 新特性（LTS）
 * 1. 密封类正式化  2. instanceof 模式匹配正式化
 * 3. 伪随机数生成器 API  4. NPE 信息默认启用
 */
public class Demo01_Java17Features {

    // 密封接口 + Record 组合
    sealed interface Expr permits Const, Add, Mul {
        double eval();
    }
    record Const(double value) implements Expr {
        public double eval() { return value; }
    }
    record Add(Expr left, Expr right) implements Expr {
        public double eval() { return left.eval() + right.eval(); }
    }
    record Mul(Expr left, Expr right) implements Expr {
        public double eval() { return left.eval() * right.eval(); }
    }

    public static void main(String[] args) {
        // 密封类 + Record
        Expr expr = new Add(new Const(3), new Mul(new Const(4), new Const(5)));
        System.out.println("3 + (4 * 5) = " + expr.eval());
        printExpr(expr, 0);

        // RandomGenerator API
        System.out.println("\n可用随机算法 (前10):");
        RandomGeneratorFactory.all()
                .sorted((a, b) -> a.name().compareTo(b.name()))
                .limit(10)
                .forEach(f -> System.out.printf("  %-25s%n", f.name()));

        RandomGenerator rng = RandomGeneratorFactory.of("L64X128MixRandom").create(42);
        System.out.println("\nL64X128MixRandom:");
        for (int i = 0; i < 5; i++) System.out.printf("  [%d] %d%n", i + 1, rng.nextInt(100));

        // NPE 增强信息（默认启用）
        System.out.println("\nJava 17 NPE 信息:");
        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            System.out.println("  " + e.getMessage());
        }
    }

    static void printExpr(Expr expr, int indent) {
        String prefix = "  ".repeat(indent);
        if (expr instanceof Const c) {
            System.out.println(prefix + "Const(" + c.value() + ")");
        } else if (expr instanceof Add a) {
            System.out.println(prefix + "Add:");
            printExpr(a.left(), indent + 1);
            printExpr(a.right(), indent + 1);
        } else if (expr instanceof Mul m) {
            System.out.println(prefix + "Mul:");
            printExpr(m.left(), indent + 1);
            printExpr(m.right(), indent + 1);
        }
    }
}
