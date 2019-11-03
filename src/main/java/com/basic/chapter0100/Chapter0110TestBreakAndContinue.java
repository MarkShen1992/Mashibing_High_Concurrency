package com.basic.chapter0100;

/**
 * break
 * continue
 *
 * @author MarkShen1992
 * @since 20191103
 */
public class Chapter0110TestBreakAndContinue {
    public static void main(String[] args) {
        breakTest();
        continueTest();
    }

    private static void continueTest() {
        for (int i = 0; i < 10; i ++) {
            if (i == 6) continue;
            System.out.println(i);
        }
    }

    private static void breakTest() {
        for (int i = 0; i < 10; i ++) {
            if (i == 6) break;
            System.out.println(i);
        }
    }
}