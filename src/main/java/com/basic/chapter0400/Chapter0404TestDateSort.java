package com.basic.chapter0400;

/**
 * 对对象进行排序
 *
 * @author MarkShen
 * @since 20191124
 */
public class Chapter0404TestDateSort {
    public static void main(String[] args) {
        Date[] days = new Date[5];
        days[0] = new Date(2006, 5, 4);
        days[1] = new Date(2006, 7, 4);
        days[2] = new Date(2008, 5, 4);
        days[3] = new Date(2004, 5, 9);
        days[4] = new Date(2004, 5, 4);

        Date d = new Date(2006, 7, 4);
        String str = String.valueOf(d);
        // str = d.toString();
        bubbleSort(days);

        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i]);
        }

        System.out.println(binarySearch(days, d));
    }

    public static Date[] bubbleSort(Date[] a) {
        int len = a.length;
        for (int i = len - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (a[j].compare(a[j + 1]) > 0) {
                    Date temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static int binarySearch(Date[] days, Date d) {
        if (days.length == 0) return -1;

        int startPos = 0;
        int endPos = days.length - 1;
        int m = (startPos + endPos) / 2;
        while (startPos <= endPos) {
            if (d.compare(days[m]) == 0) return m;
            if (d.compare(days[m]) > 0) {
                startPos = m + 1;
            }
            if (d.compare(days[m]) < 0) {
                endPos = m - 1;
            }
            m = (startPos + endPos) / 2;
        }
        return -1;
    }
}

class Date {
    int year, month, day;

    Date(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }

    public int compare(Date date) {
        return year > date.year ? 1
                : year < date.year ? -1
                : month > date.month ? 1
                : month < date.month ? -1
                : day > date.day ? 1
                : day < date.day ? -1 : 0;
    }

    public String toString() {
        return "Year:Month:Day -- " + year + "-" + month + "-" + day;
    }
}