package com.java15;

/**
 * Java 15 新特性：密封类 (Sealed Classes)（预览，Java 17 正式化）
 * sealed 限制哪些类可以继承，子类必须声明为 final / sealed / non-sealed。
 */
public class Demo01_SealedClass {

    sealed static class Shape permits Circle, Rectangle, Triangle {
        String color;
        Shape(String color) { this.color = color; }
        abstract double area();
    }

    static final class Circle extends Shape {
        double radius;
        Circle(String color, double radius) { super(color); this.radius = radius; }
        double area() { return Math.PI * radius * radius; }
        public String toString() { return String.format("圆(%s, r=%.1f, S=%.2f)", color, radius, area()); }
    }

    static final class Rectangle extends Shape {
        double w, h;
        Rectangle(String color, double w, double h) { super(color); this.w = w; this.h = h; }
        double area() { return w * h; }
        public String toString() { return String.format("矩形(%s, %.1fx%.1f, S=%.2f)", color, w, h, area()); }
    }

    // non-sealed: 开放继承
    static non-sealed class Triangle extends Shape {
        double base, height;
        Triangle(String color, double base, double height) { super(color); this.base = base; this.height = height; }
        double area() { return 0.5 * base * height; }
        public String toString() { return String.format("三角(%s, 底=%.1f, S=%.2f)", color, base, area()); }
    }

    // Triangle 是 non-sealed，可以被自由继承
    static class EquilateralTriangle extends Triangle {
        EquilateralTriangle(String color, double side) { super(color, side, side * Math.sqrt(3) / 2); }
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle("红", 5), new Rectangle("蓝", 4, 6),
                new Triangle("绿", 3, 8), new EquilateralTriangle("黄", 4)
        };
        for (Shape s : shapes) System.out.println(s);

        System.out.println("\n子类修饰符:");
        System.out.println("  final      - 不能再被继承 (Circle, Rectangle)");
        System.out.println("  sealed     - 继续限制继承");
        System.out.println("  non-sealed - 开放继承 (Triangle)");
    }
}
