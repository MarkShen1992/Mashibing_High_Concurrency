package com.basic.chapter0200;

/**
 * 小程序分析内存，清楚理解值传递，引用传递
 *
 * 方法执行完毕，为方法分配的局部变量（stack内存）所分配的内存自动消失
 * Heap内存中的内存需要垃圾回收机制来做回收
 *
 * @author MarkShen1992
 * @since 20191106
 */
public class Chapter0202OO {
    public static void main(String[] args) {
        Chapter0202OO c = new Chapter0202OO();
        int date = 9;
        BirthDate bd = new BirthDate(1970, 7, 7 );
        BirthDate bd2 = new BirthDate(2000, 1, 1);
        c.change1(date);
        System.out.println(date);
        c.change2(bd);
        System.out.println(bd);
        c.change3(bd2);
        System.out.println(bd2);
    }

    public void change1(int i) {
        i = 1234;
    }

    public void change2(BirthDate b) {
        b = new BirthDate(22, 2, 2004);
    }

    public void change3(BirthDate b) {
        b.setDay(22);
    }
}

/**
 * 出生日期
 */
class BirthDate {
    private int year;
    private int month;
    private int day;

    public BirthDate() {}

    public BirthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "BirthDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
