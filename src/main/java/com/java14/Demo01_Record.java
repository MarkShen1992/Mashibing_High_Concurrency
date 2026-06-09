package com.java14;

/**
 * Java 14 新特性：Record 类（预览，Java 16 正式化）
 * 编译器自动生成构造函数、getter、equals、hashCode、toString。
 */
public class Demo01_Record {

    record Point(int x, int y) {}

    record Person(String name, int age) {
        // 紧凑构造函数 - 添加校验
        Person {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("姓名不能为空");
            if (age < 0 || age > 150) throw new IllegalArgumentException("年龄不合法: " + age);
        }
    }

    record Rectangle(double width, double height) {
        double area() { return width * height; }
        double perimeter() { return 2 * (width + height); }
        boolean isSquare() { return width == height; }
    }

    record Address(String city, String street) {}
    record Employee(String name, int id, Address address) {}

    public static void main(String[] args) {
        // 基本使用
        Point p1 = new Point(3, 4);
        Point p2 = new Point(3, 4);
        System.out.println("p1: " + p1);             // toString
        System.out.println("x=" + p1.x() + ", y=" + p1.y());  // getter（不是 getX）
        System.out.println("p1 == p2: " + p1.equals(p2));      // equals

        // 带校验
        Person person = new Person("张三", 25);
        System.out.println(person);
        try { new Person("", 25); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        try { new Person("李四", -1); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }

        // 带方法
        Rectangle rect = new Rectangle(5, 3);
        System.out.println(rect + " 面积=" + rect.area() + " 周长=" + rect.perimeter());
        System.out.println(new Rectangle(4, 4) + " 是正方形: " + new Rectangle(4, 4).isSquare());

        // 嵌套
        Employee emp = new Employee("王五", 1001, new Address("北京", "长安街1号"));
        System.out.println(emp);
        System.out.println("城市: " + emp.address().city());
    }
}
