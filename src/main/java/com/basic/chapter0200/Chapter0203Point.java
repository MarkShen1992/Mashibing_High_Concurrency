package com.basic.chapter0200;

/**
 * 练习例子
 *
 * @author MarkShen1992
 * @since 20191107
 */
public class Chapter0203Point {
    public static void main(String[] args) {
        Point p = new Point(1, 2, 3);
        Point p2 = new Point(0, 0, 0);
        // 函数返回值，在内存中也有一块儿空间
        double result = p.getDistance(p2);
        System.out.println(result);
    }
}

class Point {
    private double x, y, z;

    public Point() {
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getDistance(Point p) {
        return Math.sqrt(
            (this.x - p.getX()) * (this.x - p.getX()) +
            (this.x - p.getX()) * (this.x - p.getX()) +
            (this.z - p.getZ()) * (this.z - p.getZ())
        );
    }
}
