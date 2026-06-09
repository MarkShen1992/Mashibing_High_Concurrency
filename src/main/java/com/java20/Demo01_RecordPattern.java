package com.java20;

/**
 * Java 20 新特性：Record 模式（预览，Java 21 正式化）
 * 在 instanceof/switch 中解构 Record 组件。需要 JDK 20+ 运行。
 */
public class Demo01_RecordPattern {

    record Point(int x, int y) {}
    record Line(Point start, Point end) {}
    record Color(int r, int g, int b) {}
    record ColoredPoint(Point point, Color color) {}

    public static void main(String[] args) {
        // Java 16+ instanceof（不解构）
        Object obj = new Point(3, 4);
        if (obj instanceof Point p) {
            System.out.println("Point: x=" + p.x() + ", y=" + p.y());
        }

        // 嵌套访问
        Object shape = new Line(new Point(0, 0), new Point(3, 4));
        if (shape instanceof Line line) {
            double len = Math.sqrt(Math.pow(line.end().x() - line.start().x(), 2)
                    + Math.pow(line.end().y() - line.start().y(), 2));
            System.out.printf("线段长度: %.2f%n", len);
        }

        // Java 20+ Record 模式（需要 JDK 20+）
        System.out.println("\nJava 20+ Record 模式语法:");
        System.out.println("  if (obj instanceof Point(int x, int y)) { ... }");
        System.out.println("  if (shape instanceof Line(Point(var x1, var y1), Point(var x2, var y2))) { ... }");
        System.out.println("  if (colored instanceof ColoredPoint(Point(var px, var py), Color(var r, var g, var b))) { ... }");

        System.out.println("\nswitch 中使用:");
        System.out.println("  case Point(int x, int y) -> \"点(\" + x + \",\" + y + \")\";");
        System.out.println("  case Line(Point s, Point e) -> \"线段\";");
    }
}
