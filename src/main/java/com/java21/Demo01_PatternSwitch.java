package com.java21;

/**
 * Java 21 新特性（LTS）：switch 模式匹配（正式化）
 * 类型模式、Record 模式、守卫条件 when、null 匹配。需要 JDK 21 运行。
 */
public class Demo01_PatternSwitch {

    sealed interface Shape permits Circle, Rectangle, Triangle {}
    record Circle(double radius) implements Shape {}
    record Rectangle(double width, double height) implements Shape {}
    record Triangle(double base, double height) implements Shape {}

    // Java 17 兼容写法
    static double area(Shape s) {
        if (s instanceof Circle c) return Math.PI * c.radius() * c.radius();
        if (s instanceof Rectangle r) return r.width() * r.height();
        if (s instanceof Triangle t) return 0.5 * t.base() * t.height();
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Shape[] shapes = {new Circle(5), new Rectangle(4, 6), new Triangle(3, 8)};
        for (Shape s : shapes) System.out.printf("  %s -> 面积=%.2f%n", s, area(s));

        // Java 21 switch 模式匹配语法
        System.out.println("\nJava 21 语法:");
        System.out.println("  return switch (shape) {");
        System.out.println("      case Circle c -> Math.PI * c.radius() * c.radius();");
        System.out.println("      case Rectangle r -> r.width() * r.height();");
        System.out.println("      case Triangle t -> 0.5 * t.base() * t.height();");
        System.out.println("  };  // 密封类型无需 default!");
        System.out.println();
        System.out.println("  case Circle c when c.radius() > 10 -> \"大圆\";");
        System.out.println("  case Circle c -> \"圆\";");
        System.out.println();
        System.out.println("  case ColoredShape(Circle c, String color) -> ...;");
        System.out.println("  case Line(Point(var x1, var y1), Point(var x2, var y2)) -> ...;");
        System.out.println("  case null -> \"null\";");

        System.out.println("\n优势:");
        System.out.println("  1. 编译器穷举检查（密封类型）");
        System.out.println("  2. Record 解构，无需 getter");
        System.out.println("  3. when 守卫条件");
        System.out.println("  4. 支持 null 匹配");
    }
}
