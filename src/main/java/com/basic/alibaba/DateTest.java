package com.basic.alibaba;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * 日期时间规约
 *
 * @author MarkShen1992
 * @since 20200508
 */
public class DateTest {

    private final static String PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 月
     */
    private final static int MONTH = 1;

    /**
     * 日
     */
    private final static int DAY = 1;

    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat(PATTERN);
        System.out.println(dateFormat.format(new Date()));

        // 获取当前毫秒数
        System.out.println(System.currentTimeMillis());
        // 纳秒
        System.out.println(System.nanoTime());

        // 统计时间等场景
        // Instant

        // 获取今年的天数
        int daysOfThisYear = LocalDate.now().lengthOfYear();
        System.out.println(daysOfThisYear);

        // 获取指定某年的天数
        System.out.println(getDaysOfCurrentYear(2016));
    }

    private static int getDaysOfCurrentYear(int currentYear) {
        return LocalDate.of(currentYear, MONTH, DAY).lengthOfYear();
    }
}
