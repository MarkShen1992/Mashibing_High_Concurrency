package com.basic.chapter0400;

/**
 * 数三退一
 *
 * @author MarkShen
 * @since 20191124
 */
public class Count3Quit {
    public static void main(String[] args) {
        boolean[] arr = new boolean[500];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }

        int leftCount = arr.length;
        int countNum = 0;
        int index = 0;

        while (leftCount > 1) {
            if (arr[index] == true) {
                countNum++;
                if (countNum == 3) {
                    countNum = 0;
                    arr[index] = false;
                    leftCount--;
                }
            }

            index++;

            if (index == arr.length) {
                index = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true) {
                System.out.println(i);
            }
        }
    }
}